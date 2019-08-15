package ai.code.practise.rikudo.akka.supervisor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class SupervisorMain {
    public static void main(String[] args){
        Expression expression = new AbstractExpression.Add(new Const(5), new Const(3));

        ActorSystem actorSystem = ActorSystem.create("actorSystem");
        ActorRef actorRef = actorSystem.actorOf(FlasyExpressionCalculator.props(expression, FlasyExpressionCalculator.Position.Left), "calculator");

    }
}
