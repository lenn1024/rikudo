package ai.code.practise.rikudo.spring.aop.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 方法拦截
 * 通知的具体逻辑实现
 */
public class LoggableInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Logger logger = LoggerFactory.getLogger(methodInvocation.getThis().getClass());

        // 获取
        Object instance = methodInvocation.getThis();
        // 输出入参日志
        logger.info("invoke start, class: {}, method: {}, args:{}.", instance.getClass().getName(), methodInvocation.getMethod().getName(), methodInvocation.getArguments());

        // 执行方法逻辑
        Object result = methodInvocation.proceed();

        // 输出出参日志
        logger.info("invoke end, class: {}, method: {}, result:{}", instance.getClass().getName(), methodInvocation.getMethod().getName(), result);

        return result;
    }
}
