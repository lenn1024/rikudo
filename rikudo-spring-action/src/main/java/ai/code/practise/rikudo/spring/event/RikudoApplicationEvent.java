package ai.code.practise.rikudo.spring.event;

import org.springframework.context.ApplicationEvent;

public class RikudoApplicationEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public RikudoApplicationEvent(Object source) {
        super(source);
    }
}
