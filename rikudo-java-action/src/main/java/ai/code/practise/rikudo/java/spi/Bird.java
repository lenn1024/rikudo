package ai.code.practise.rikudo.java.spi;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Bird implements Flyable {

    @Override
    public void fly() {
        log.info("Bird is flying.");
    }
}
