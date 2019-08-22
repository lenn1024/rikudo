package ai.code.practise.rikudo.spring.aop.annotationconfig;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;

@Slf4j
@Aspect
public class DriveAspect {

    @Pointcut("execution(* ai.code.practise.rikudo.spring.aop.annotationconfig.RikudoDriver.drive(..))")
    public void drive(){}

    @Before("drive()")
    public void addPetrol(){
        log.info("把邮箱加满。");
    }

    @After("drive()")
    public void parkCar(){
        log.info("将车停好。");
    }

    @AfterReturning("drive()")
    public void sleep(){
        log.info("去睡觉了。");
    }

    @AfterThrowing("drive()")
    public void dropAnchor(){
        log.info("车抛锚了。");
    }

    @Pointcut("execution(* ai.code.practise.rikudo.spring.aop.annotationconfig.RikudoDriver.buyCar(..)) && args(carName)")
    public void buyCar(String carName){
    }

    @Before("buyCar(carName)")
    public void borrowMoney(String carName){
        log.info("找朋友借点钱。");
    }
}
