package ai.code.practise.rikudo.java.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulerThreadPoolDemo {

    private static final Logger logger = LoggerFactory.getLogger(SchedulerThreadPoolDemo.class);

    public static void main(String[] args){
        /**
         * ScheduleExecutorService demo
         */
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor(
                (runnable) -> {
                    Thread thread = new Thread(runnable);
                    thread.setName("log current time thread");
                    thread.setDaemon(false);
                    return thread;
                }
        );

        executorService.scheduleWithFixedDelay(() -> {
            logger.info("当前时间1: {}.", new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()));
        }, 1, 1, TimeUnit.SECONDS);
    }
}
