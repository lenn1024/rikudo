package ai.code.practise.rikudo.java.spi;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Airplane implements Flyable {

    @Override
    public void fly() {
        log.info("Airplane is flying.");
    }
}
