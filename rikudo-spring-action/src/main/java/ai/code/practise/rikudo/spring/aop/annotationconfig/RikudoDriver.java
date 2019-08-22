package ai.code.practise.rikudo.spring.aop.annotationconfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RikudoDriver {

    /***
     * 开车去某地
     * @param car
     */
    public void drive(String car){
        log.info("rikudo drive {} to work.", car);
    }

    /**
     * 买车
     * @param carName
     */
    public void buyCar(String carName){
        log.info("rikudo buy a car of {}.", carName);
    }
}
