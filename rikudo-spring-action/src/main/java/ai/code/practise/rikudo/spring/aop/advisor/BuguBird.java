package ai.code.practise.rikudo.spring.aop.advisor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Loggable
@Component
@Slf4j
public class BuguBird {

    public void fly(){
        log.info("Bugu bird fly.");
    }

    public String song(String songName){
        return songName + ": bugu bugu.";
    }
}
