package ai.code.practise.rikudo.design.pattern.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Slf4j
public class DynamicProxy {
    public static void main(String[] args){

        Subject realSubject = new RealSubject();

        Subject dynamicProxy = (Subject) Proxy.newProxyInstance(DynamicProxy.class.getClassLoader(), new Class[]{Subject.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                log.info("before invoke.");
                method.invoke(realSubject, args);
                return null;
            }
        });

        dynamicProxy.process();
    }
}
