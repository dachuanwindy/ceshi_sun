package com.classLoaderStudy;

import java.lang.reflect.ParameterizedType;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author sunfch
 * @version V1.0
 * @Description: classLoader 学习
 * @date 2020/5/7 23:02
 */
public class ClassLoadStd {

    public static void main(String[] args) {
        // 根加载器,最顶层对象是根加载器
        Object o = new Object();
        new Object().getClass();
        ClassLoader classLoader = o.getClass().getClassLoader();
//        System.out.println(classLoader.toString());

        ClassLoader classLoader1 = ClassLoadStd.class.getClassLoader();
        System.out.println("程序类加载器" + classLoader1.toString());


        String path="/opt/DemoTest.class";


    }
}
