package ai.code.practise.rikudo.spring.demo;

import ai.code.practise.rikudo.spring.component.BuguBird;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoggableMain {

    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        BuguBird buguBird = applicationContext.getBean(BuguBird.class);
        buguBird.fly();
        buguBird.song("hello");

        DefaultPointcutAdvisor advisor = (DefaultPointcutAdvisor)applicationContext.getBean("loggablePointcutAdvisor");
        advisor.toString();
    }
}
