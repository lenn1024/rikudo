package ai.code.practise.rikudo.spring.aop.proxyfactory.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

@Slf4j
public class CleanAfterFlyInterceptor implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        log.info("飞机降落后，擦洗飞机。");
    }
}
