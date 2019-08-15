package ai.code.practise.rikudo.spring.autoconfig;

import ai.code.practise.rikudo.spring.annotation.Loggable;
import ai.code.practise.rikudo.spring.aop.interceptor.LoggableInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggableConfiguration {

    @Bean
    public DefaultPointcutAdvisor loggablePointcutAdvisor(){
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();

        advisor.setPointcut(new AnnotationMatchingPointcut(Loggable.class, true));
        advisor.setAdvice(new LoggableInterceptor());

        return advisor;
    }
}
