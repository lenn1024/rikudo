package ai.code.practise.rikudo.spring.aop;

import ai.code.practise.rikudo.spring.aop.advisor.BuguBird;
import ai.code.practise.rikudo.spring.aop.annotationconfig.RikudoDriver;
import ai.code.practise.rikudo.spring.aop.xmlconfig.FilmLover;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring/applicationContext.xml"})
public class AopTest implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Test
    public void testAdvisor(){
        BuguBird buguBird = this.applicationContext.getBean(BuguBird.class);
        buguBird.fly();
        buguBird.song("hello");
    }

    @Test
    public void testXmlAop(){
        FilmLover filmLover = this.applicationContext.getBean(FilmLover.class);

        String filmName = "八臂哪吒";
        filmLover.downloadFilm(filmName);
        filmLover.watchFilm(filmName);
    }

    @Test
    public void testAnnotationAop(){
        RikudoDriver driver = this.applicationContext.getBean(RikudoDriver.class);
        String carName = "BMW";
        driver.buyCar(carName);
        driver.drive(carName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
