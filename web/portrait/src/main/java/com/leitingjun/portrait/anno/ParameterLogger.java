package com.leitingjun.portrait.anno;

import java.lang.annotation.*;

/**
 * 打印出差入参注解
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ParameterLogger {
    int userId() default 0;

}
