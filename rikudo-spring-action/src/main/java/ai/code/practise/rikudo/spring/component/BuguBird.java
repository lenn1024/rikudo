package ai.code.practise.rikudo.spring.component;

import ai.code.practise.rikudo.spring.annotation.Loggable;
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
