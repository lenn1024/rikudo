package ai.code.practise.rikudo.spring.aop.proxyfactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AirPlane implements Flyable {
    @Override
    public void fly() {
        log.info("起飞去北京。");
    }
}
