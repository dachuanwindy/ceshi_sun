package com.spring.ioc;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/7/8 10:59
 */
public class TestMain {

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        System.out.println("实现依赖注入");
        UserController userController = new UserController();
        UserService userService = new UserService();
        Class<? extends UserController> clazz = userController.getClass();
        Field userserviceField = clazz.getDeclaredField("userService");
        userserviceField.setAccessible(true);

        String name = userserviceField.getName();
        System.out.println("输出字段名字是什么" + name);

        name = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
        String name2 = "set" + name;
        System.out.println("输出的Name2" + name2);

        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            String string = method.getName().toString();
            System.out.println(string);
        }
        System.out.println(methods);

        Method getUserService = clazz.getMethod("setUserService", UserService.class);
        getUserService.invoke(userController, userService);
        System.out.println(userController.getUserService());


    }

}
