package ai.code.practise.rikudo.spring.domain;

import lombok.Data;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * 定义一个美女
 */
@Data
public class Beauty implements ApplicationEventPublisherAware {

    private String name;

    private int age;

    private Car car;

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
