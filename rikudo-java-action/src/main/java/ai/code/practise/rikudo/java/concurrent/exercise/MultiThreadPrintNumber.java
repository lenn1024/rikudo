package ai.code.practise.rikudo.java.concurrent.exercise;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程交替打印 0 ~ 100的数字
 * TODO 待完善
 */
@Slf4j
public class MultiThreadPrintNumber {

    public static void main(String[] args){
        MultiThreadPrintNumber instance = new MultiThreadPrintNumber(3);
        instance.printNumber();
    }


    /**
     * 初始化线程的个数
     */
    private int threadCount;

    /**
     * 线程池
     */
    private ExecutorService executorService;

    /**
     * 锁
     */
    private Lock lock;

    private Condition[] conditions;

    public MultiThreadPrintNumber(int threadCount) {
        this.threadCount = threadCount;
        this.executorService = Executors.newFixedThreadPool(threadCount);

        this.lock = new ReentrantLock();
        this.conditions = new Condition[threadCount];
        for(int i = 0; i < threadCount; i++){
            conditions[i] = lock.newCondition();
        }
    }

    public void printNumber(){
        for(int i = 0; i < threadCount; i++){
            executorService.submit(new PrintNumberTask(lock, conditions, threadCount, i));
        }

        this.executorService.shutdown();
    }

    /**
     * 打印数字的任务
     */
    static class PrintNumberTask implements Runnable{

        private Lock lock;

        private Condition[] conditions;

        private static volatile int number;

        private int taskNo;

        private int taskCount;

        public PrintNumberTask(Lock lock, Condition[] conditions, int taskCount, int taskNo) {
            this.lock = lock;
            this.conditions = conditions;
            this.taskCount = taskCount;
            this.taskNo = taskNo;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                while (number <= 100){
                    if(number % taskCount == taskNo){
                        log.info("打印数字：{}.", number++);
                    }
                    this.conditions[(taskNo + 1) % taskCount].signal();
                    this.conditions[taskNo].await();
                }
                int nextSignal = (taskNo + 1) % taskCount;
                log.info("thread-{}结束运行, 唤醒thread-{}", taskNo, nextSignal);
                this.conditions[nextSignal].signal();
            } catch (InterruptedException e) {
                log.error("InterruptedException", e);
            } finally {
                lock.unlock();
            }
        }
    }
}
