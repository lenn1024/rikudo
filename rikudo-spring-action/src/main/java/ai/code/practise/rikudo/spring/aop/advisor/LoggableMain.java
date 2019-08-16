package ai.code.practise.rikudo.spring.aop.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoggableMain {

    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        BuguBird buguBird = applicationContext.getBean(BuguBird.class);
        buguBird.fly();
        buguBird.song("hello");
    }
}
