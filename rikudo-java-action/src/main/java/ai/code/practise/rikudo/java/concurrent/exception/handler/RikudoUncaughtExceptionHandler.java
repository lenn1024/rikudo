package ai.code.practise.rikudo.java.concurrent.exception.handler;

import lombok.extern.slf4j.Slf4j;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * 为某个线程设置异常处理器
 * 当这个线程抛出未捕获异常时，由设置的异常处理器进行处理
 */
@Slf4j
public class RikudoUncaughtExceptionHandler implements UncaughtExceptionHandler {

    /**
     * 将异常所发生的线程和异常信息记录到日志
     * @param t
     * @param e
     */
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        log.error(String.format("Thread [%s] had a exception:", t.getName()), e);
    }

    public static void main(String[] args){
        Thread t = new Thread(() -> {
            throw new RuntimeException("lenn人为抛出一个测试异常。");
        });
        t.setName("测试子线程");
        t.setUncaughtExceptionHandler(new RikudoUncaughtExceptionHandler());
        t.start();
    }
}
