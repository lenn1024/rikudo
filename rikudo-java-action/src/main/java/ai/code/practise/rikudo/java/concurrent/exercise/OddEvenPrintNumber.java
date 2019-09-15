package ai.code.practise.rikudo.java.concurrent.exercise;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替打印 0~100 的整数
 */
@Slf4j
public class OddEvenPrintNumber {

    private static int number = 0;

    public static void main(String[] args){
        Lock lock = new ReentrantLock();

        Condition printOddNumberCondition = lock.newCondition();
        Condition printEvenNumberCondition = lock.newCondition();

        Thread oddThread = new Thread(() -> {
            lock.lock();
            try {
                while (number < 100){
                    if(number % 2 != 0){
                        log.info("打印数字：{}.", number++);
                    }
                    printEvenNumberCondition.signal();
                    printOddNumberCondition.await();
                }
            } catch (InterruptedException e) {
                log.error("InterruptedException.", e);
            } finally {
                lock.unlock();
            }
        });
        oddThread.setName("奇线程");
        oddThread.start();

        Thread evenThread = new Thread(() -> {
            lock.lock();
            try {
                while (number <= 100){
                    if(number % 2 == 0){
                        log.info("打印数字：{}.", number++);
                    }
                    printOddNumberCondition.signal();
                    if(number > 100){
                        break;
                    }
                    printEvenNumberCondition.await();
                }
            } catch (InterruptedException e) {
                log.error("InterruptedException.", e);
            } finally {
                lock.unlock();
            }
        });
        evenThread.setName("偶线程");
        evenThread.start();

    }
}
