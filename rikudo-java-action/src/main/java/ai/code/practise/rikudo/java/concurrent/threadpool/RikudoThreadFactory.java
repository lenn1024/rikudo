package ai.code.practise.rikudo.java.concurrent.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义线程工厂
 */
public class RikudoThreadFactory implements ThreadFactory {

    private static final AtomicInteger threadNumber = new AtomicInteger(1);

    /**
     * 业务名称
     */
    private String bizName;

    /**
     * 线程前缀
     */
    private String threadNamePrefix;

    public RikudoThreadFactory(String bizName){
        this.bizName = bizName;
        this.threadNamePrefix = "线程-" + this.bizName + "-";
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(null, r,
                threadNamePrefix + threadNumber.getAndIncrement(),
                0);
        return t;
    }
}
