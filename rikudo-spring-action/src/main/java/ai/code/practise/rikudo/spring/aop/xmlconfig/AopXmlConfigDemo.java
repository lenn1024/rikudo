package ai.code.practise.rikudo.spring.aop.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * xml config aop 实现
 */
public class AopXmlConfigDemo {

    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        FilmLover filmLover = (FilmLover) applicationContext.getBean("filmLover");

        String filmName = "八臂哪吒";
        filmLover.downloadFilm(filmName);
        filmLover.watchFilm(filmName);
    }
}
