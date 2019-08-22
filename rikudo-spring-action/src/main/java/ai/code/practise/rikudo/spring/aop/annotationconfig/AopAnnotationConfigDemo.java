package ai.code.practise.rikudo.spring.aop.annotationconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 注解实现AOP demo
 */
public class AopAnnotationConfigDemo {

    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        RikudoDriver driver = (RikudoDriver) applicationContext.getBean("rikudoDriver");
        String carName = "BMW";
        driver.buyCar(carName);
        driver.drive(carName);
    }
}
