package ai.code.practise.rikudo.netty.socket;

import ai.code.practise.rikudo.common.SleepHelper;

import java.io.IOException;
import java.net.Socket;

public class Client {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8000;
    public static final int SLEEP_TIME = 3000;

    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket(HOST, PORT);
        new Thread(new Runnable() {
            public void run() {
                System.out.println("客户端启动成功。");
                while (true){
                    String message = "Hello World!";
                    System.out.println("客户端发送数据:" + message);
                    try {
                        socket.getOutputStream().write(message.getBytes());
                    } catch (IOException e) {
                        System.out.println("客户端发送数据出错。");
                    }
                    // sleep 3s
                    SleepHelper.sleep(SLEEP_TIME);
                }
            }
        }).start();
    }


}
