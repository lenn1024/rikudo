package ai.code.practise.rikudo.java;

import ai.code.practise.rikudo.java.spi.Flyable;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ServiceLoader;

@Slf4j
public class TestMain {

    @Test
    public void testFloat(){
        log.info("{}", 0f);
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
