package com.XLH_study;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {
    public ReflectTest() {
    }

    public static void huoqu() throws Exception {
        //获取任意类型对象，
        Class<?> clazzType = Class.forName("com.XLH_study.Consunmer");
//        Type type = Class.forName("com.XLH_study.Consunmer");
        Field[] method = clazzType.getDeclaredFields();
 /*       for (Field f : method) {
            System.out.println(f.getName());
        }*/
        for (int i = 0; i < method.length; i++) {
            Field field = method[i];
            String methodname = field.getName();
            System.out.println("@@@@@@@" + methodname);
            String method_get = "get" + methodname.substring(0, 1).toUpperCase() + methodname.substring(1);
            System.out.println(">>>" + method_get);
            String method_set = "set" + methodname.substring(0, 1).toUpperCase() + methodname.substring(1);
            System.out.println(">>>" + method_set);
            Method m1 = clazzType.getMethod(method_get, new Class[]{});

            Method m2 = clazzType.getMethod(method_set, new Class[]{field.getType()});

            Object ob = clazzType.getConstructor(new Class[]{String.class, int.class}).newInstance(new Object[]{"zhangsan", 23});

            m1.invoke(ob);
            m2.invoke(ob);


        }
    }


}



