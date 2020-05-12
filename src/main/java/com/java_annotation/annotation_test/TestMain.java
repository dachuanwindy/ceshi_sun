package com.java_annotation.annotation_test;

import com.java_annotation.annotation_test.annotation_interface.TestA;

import java.lang.annotation.Annotation;

/**
 * @author sunfch
 * @create 2018-08-26 16:30
 * @desc 测试主函数
 * <p>
 * 测试方法的一般步骤是先写类，最后将测试主函数卸载外边
 **/
public class TestMain {

    public static void main(String args[]) throws ClassNotFoundException {
        System.out.println("===========================");
        method();
    }
    public static void method() throws ClassNotFoundException {

        Class clazz = Class.forName("com.java_annotation.annotation_test.annotation_test2.Test2");

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            TestA testA = (TestA) annotation;
            System.out.println("id= " + testA.id() + "; name= " + testA.name() + "; gid=" + testA.Gid());
        }
    }

}
