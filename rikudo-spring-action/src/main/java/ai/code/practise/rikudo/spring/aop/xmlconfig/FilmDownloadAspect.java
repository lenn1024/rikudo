package ai.code.practise.rikudo.spring.aop.xmlconfig;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;

@Slf4j
public class FilmDownloadAspect {

    /**
     * 下载一个电影
     * @param joinPoint
     */
    public void downloadFilm(ProceedingJoinPoint joinPoint){
        try {
            log.info("调查最近好看的电影。");
            joinPoint.proceed();
            log.info("电影下载完毕。");
        }catch (Throwable throwable){
            log.info("我靠，断网了，下不下来了。");
        }
    }
}
