package ai.code.practise.rikudo.java;

import ai.code.practise.rikudo.common.SleepHelper;
import ai.code.practise.rikudo.java.spi.Flyable;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.ServiceLoader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Java语法小测试
 */
@Slf4j
public class JavaTest {

    @Test
    public void testThreadPool(){
        ExecutorService threadPoolExecutor = Executors.newCachedThreadPool();

        threadPoolExecutor.submit(() -> {
           for(int i = 0; i < 10; i++){
               log.info("this number is {}.", i);
           }
        });

        SleepHelper.sleep(3000);
        threadPoolExecutor.shutdown();
    }

    @Test
    public void testArray(){
        int[] arr1 = new int[10];
        int[] arr2 = new int[5];

        System.arraycopy(arr1, 0, arr2, 0, 5);

        int[] originalArr = {1, 2, 3, 4, 5};
        int[] destArr = Arrays.copyOf(originalArr, 10);

        log.info("dest arr is {}.", Arrays.asList(destArr));
    }

    @Test
    public void testString(){
        String s1 = "lenn";
        String s2 = "lenn";
        log.info("s1 == s2 : {}", s1 == s2);

        String s3 = new String("lenn");
        String s4 = new String("lenn");
        log.info("s1 == s3 : {}", s1 == s3);
        log.info("s3 == s4 : {}", s3 == s4);

        StringBuilder sb = new StringBuilder("lenn");
        String s5 = sb.toString();
        String s6 = sb.toString();
        log.info("s5 == s6: {}", s5 == s6);

        String s7 = new StringBuilder("计算机").append("软件").toString();
        log.info("s7.intern() == s7: {}", s7.intern() == s7);

        String s8 = new StringBuilder("ja").append("va").toString();
        log.info("s8.intern() == s8: {}", s8.intern() == s8);
    }

    /**
     * Java的位移
     */
    @Test
    public void testBitShift(){
        // 正数左移
        log.info("1 << 1 == {}", 1 << 1);
        log.info("1 << 32 == {}", 1 << 32);
        log.info("1 << 33 == {}", 1 << 33);

        // 负数左移
        log.info("-1 << 1 == {}", -1 << 1);
        log.info("-1 << 32 == {}", -1 << 32);
        log.info("-1 <<33 == {}", -1 << 33);

        // 正数右移
        log.info("1 >> 1 == {}", 1 >> 1);
        log.info("1 >> 32 == {}", 1 >> 32);
        log.info("1 >> 33 == {}", 1 >> 33);

        // 负数右移
        log.info("-1 >> 1 == {}", -1 >> 1);
        log.info("-1 >> 32 == {}", -1 >> 32);
        log.info(" -1 >> 33 == {}", -1 >> 33);

        // 无符号右移（不存在无符号左移）
        log.info("-1 >>> 1 == {}", -1 >>> 1);
        log.info("-1 >>> 31 == {}", -1 >>> 31);
        log.info("-1 >>> 32 == {}", -1 >>> 32);
    }

    /**
     * Java spi机制
     */
    @Test
    public void testJavaSpi(){
        ServiceLoader<Flyable> serviceLoader = ServiceLoader.load(Flyable.class);
        log.info("Java SPI.");
        serviceLoader.forEach(Flyable::fly);
    }
}
