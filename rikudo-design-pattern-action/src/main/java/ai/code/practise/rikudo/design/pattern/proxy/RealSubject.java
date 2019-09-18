package ai.code.practise.rikudo.design.pattern.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealSubject implements Subject {
    @Override
    public void process() {
        log.info("do something to process.");
    }
}
