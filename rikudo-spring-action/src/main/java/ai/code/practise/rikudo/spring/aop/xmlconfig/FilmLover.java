package ai.code.practise.rikudo.spring.aop.xmlconfig;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 电影爱好者
 */
@Data
@Slf4j
public class FilmLover {

    private String name;

    public FilmLover(String name) {
        this.name = name;
    }

    public void watchFilm(){
        log.info("{} watch film: {}.", name, "Lost");
    }

    public void watchFilm(String filmName){
        log.info("{} watch film: {}.", this.name, filmName);
        throw new RuntimeException("电影太垃圾了，不看了。");
    }

    public void downloadFilm(String filmName){
        log.info("{} download the film of {}.", this.name, filmName);
    }
}
