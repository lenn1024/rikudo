package ai.code.practise.rikudo.java;

import ai.code.practise.rikudo.java.spi.Flyable;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ServiceLoader;

@Slf4j
public class TestMain {

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
