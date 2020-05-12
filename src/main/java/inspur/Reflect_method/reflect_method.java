package inspur.Reflect_method;

import java.lang.reflect.Method;

public class reflect_method {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("java.util.HashSet");
            Object o = c.newInstance();
            Method[] methods = c.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }
            Method m1 = c.getMethod("add", Object.class);
            m1.invoke(o, "cyq");
            m1.invoke(o, "hello");
            m1.invoke(o, "java");
            System.out.println(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}