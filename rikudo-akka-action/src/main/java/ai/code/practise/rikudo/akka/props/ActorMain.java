package ai.code.practise.rikudo.akka.props;

import akka.actor.ActorSystem;
import akka.actor.Props;

public class ActorMain {
    public static void main(String[] args){
        ActorSystem actorSystem = ActorSystem.create("actorSystem");
        actorSystem.actorOf(Props.create(StartActor.class), "startActor");
    }
}
