package ai.code.practise.rikudo.spring.aop.proxyfactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopProxyMain {

    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        Flyable flyable = (Flyable) applicationContext.getBean("airPlaneProxy");
        flyable.fly();
    }
}
