package ai.code.practise.rikudo.java.concurrent.threadpool;

import ai.code.practise.rikudo.common.SleepHelper;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadPoolExecutorDemo {

    public static void main(String[] args){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,
                1,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                new RikudoThreadFactory("线程池测试"),
                new RikudoRejectHandler());

        threadPoolExecutor.submit(() -> {
            log.info("毛主席万岁！");
            SleepHelper.sleep(100);
        });
        threadPoolExecutor.submit(() -> {
            log.info("习大大万岁！");
            SleepHelper.sleep(100);
        });
        threadPoolExecutor.submit(() -> {
            log.info("祖国万岁！");
            SleepHelper.sleep(100);
        });

        threadPoolExecutor.shutdown();
    }
}
