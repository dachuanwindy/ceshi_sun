package com.java_annotation.annotation_test.annotation_interface;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

// 注解可以作用在类 方法 还有变量上
@Target({TYPE, METHOD, FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestA {
    String name();

    int id() default 0;

    Class Gid();
}
