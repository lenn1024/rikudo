package ai.code.practise.rikudo.spring.aop.advisor;

import org.springframework.stereotype.Component;

@Loggable
@Component
public class BuguBird {

    public void fly(){
        System.out.println("Bugu bird fly.");
    }

    public String song(String songName){
        return songName + ": bugu bugu.";
    }
}
