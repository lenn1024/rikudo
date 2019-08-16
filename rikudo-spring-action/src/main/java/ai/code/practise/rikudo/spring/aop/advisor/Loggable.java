package ai.code.practise.rikudo.spring.aop.advisor;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Loggable {
    String value() default "";
}
