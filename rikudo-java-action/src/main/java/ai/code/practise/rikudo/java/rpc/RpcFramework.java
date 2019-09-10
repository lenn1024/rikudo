package ai.code.practise.rikudo.java.rpc;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class RpcFramework {

    /**
     * 暴露服务
     *
     * @param service 服务实现
     * @param port 服务端口
     * @throws Exception
     */
    public static void export(final Object service, int port)
            throws Exception {
        if(service == null){
            throw new IllegalArgumentException("service instance is null.");
        }

        if(port <= 0 || port > 65535){
            throw new IllegalArgumentException("Invalid port: " + port);
        }

        // 具体实现逻辑
        log.info("Export service " + service.getClass().getName() + " on port " + port);
        ServerSocket server = new ServerSocket(port);
        for (;;){
            final Socket socket = server.accept();
            new Thread(() -> {
                ObjectInputStream inputStream = null;
                try {
                    inputStream = new ObjectInputStream(socket.getInputStream());
                    String methodName = inputStream.readUTF();
                    Class<?>[] parameterTypes = (Class<?>[]) inputStream.readObject();
                    Object[] arguments = (Object[]) inputStream.readObject();

                    // 执行相应逻辑并回写结果
                    ObjectOutputStream outputStream = null;
                    try {
                        outputStream = new ObjectOutputStream(socket.getOutputStream());
                        Method method = service.getClass().getMethod(methodName, parameterTypes);
                        Object result = method.invoke(service, arguments);
                        outputStream.writeObject(result);
                    } catch (Throwable t) {
                        log.error("output stream write exception.", t);
                    } finally {
                        outputStream.close();
                    }
                } catch (Throwable t) {
                    log.error(".", t);
                } finally {
                    try {
                        inputStream.close();
                        socket.close();
                    } catch (IOException e) {
                        log.error("inputStream close exception.", e);
                    }
                }
            }).start();
        } // end of for
    } // end of method


    /**
     * 引用服务
     *
     * @param interfaceClass 接口类型
     * @param host 服务器主机名
     * @param port 服务器端口
     * @param <T> 接口泛型
     * @return 远程服务
     * @throws Exception
     */
    public static <T> T refer(final Class<T> interfaceClass, final String host, final int port)
            throws Exception{

        if(interfaceClass == null){
            throw new IllegalArgumentException("Interface class == null");
        }

        if(!interfaceClass.isInterface()){
            throw new IllegalArgumentException("The " + interfaceClass.getName() + "must be interface class.");
        }

        if(host == null || host.length() == 0){
            throw new IllegalArgumentException("host is empty.");
        }

        if(port <= 0 || port > 65535){
            throw new IllegalArgumentException("Invalid port " + port);
        }

        log.info("Get remote service " + interfaceClass.getName() + " from server " + host + ":" + port);
        T proxy = (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = new Socket(host, port);
                try {
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    try {
                        outputStream.writeUTF(method.getName());
                        outputStream.writeObject(method.getParameterTypes());
                        outputStream.writeObject(args);

                        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                        try {
                            Object result = inputStream.readObject();
                            if(result instanceof Throwable){
                                throw (Throwable) result;
                            }
                            return result;
                        }finally {
                            inputStream.close();
                        }
                    }finally {
                        outputStream.close();
                    }
                }finally {
                    socket.close();
                }
            }
        });

        return proxy;
    }
}
