package ai.code.practise.rikudo.spring.ioc;

import ai.code.practise.rikudo.spring.domain.Beauty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class ApplicationContextMain {

    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-ioc.xml");
        Beauty beauty = applicationContext.getBean(Beauty.class);

        log.info("Beauty is {}.", beauty);
    }
}