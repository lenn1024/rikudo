package ai.code.practise.rikudo.spring.aop.xmlconfig;

import lombok.extern.slf4j.Slf4j;

/**
 * 电影观看切面
 * 通知：前置通知，后置通知，返回通知，异常通知
 */
@Slf4j
public class FilmWatchAspect {

    /**
     * 挑选电影
     * @return
     */
    public String selectFilm(String filmName){
        log.info("select a film({}) to watch.", filmName);
        return filmName;
    }

    /**
     * 购买电影票
     */
    public void buyTicket(String filmName){
        log.info("buy a ticket of film '{}'.", filmName);
    }

    /**
     * 写影评
     */
    public void writeFilmReview(String filmName){
        log.info("write film review of {}.", filmName);
    }

    /**
     * 退票
     * @param filmName
     */
    public void refund(String filmName){
        log.info("电影不好看，退票。");
    }

    /**
     * 走出电影院
     */
    public void walkOutOfCinema(String filmName){
        log.info("Walk out of the cinema.");
    }
}
