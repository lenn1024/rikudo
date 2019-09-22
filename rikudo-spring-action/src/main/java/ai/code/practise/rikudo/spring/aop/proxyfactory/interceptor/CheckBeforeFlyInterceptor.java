package ai.code.practise.rikudo.spring.aop.proxyfactory.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

@Slf4j
public class CheckBeforeFlyInterceptor implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        log.info("检查飞机各部件是否完好。");
    }
}
