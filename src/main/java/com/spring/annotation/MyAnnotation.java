package com.spring.annotation;

import java.lang.annotation.*;

/**
 * @author sunfch
 * @description: 自定义注解
 * @date 2020/7/18 10:25
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface MyAnnotation {
    String value() default "test";
}
