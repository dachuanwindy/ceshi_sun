package com.Reflect.reflect_ceshi;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.concurrent.*;

/**
 * @author sunfch
 * @create 2018-11-10 9:49
 * @desc 反射测试
 **/
public class ReflectTest {

    public static void main(String[] args) {
//        replaceword();
        // System.out.println(ceshi("students. am i"));
//
//        User user = new User("121212", 12);
//        System.out.println(user.toString());
//        System.out.println(user.hashCode());
//
//        User user1 = user;
//        System.out.println(user1.toString());
//        System.out.println(user1.hashCode());
//        user1.setName("sunfengchuan");
//        System.out.println(user.toString());
//
//        Class clazz = User.class;

        int[] ints = new int[4];

        Class<? extends int[]> aClass = ints.getClass();
        Method[] methods = aClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
        }

    }

    public static void replaceword() {
        String value = "we are happey  ";
        String value1 = value.replace(" ", "**");
        System.out.println(value1);
        String vale2 = "we are happy  ";
        char[] arr = vale2.toCharArray();

        for (int i = 0; i < arr.length; i++) {
         /*   if (Character.isSpaceChar(arr[i])) {
                System.out.println("==========");
            }*/
            if (arr[i] == '\0') {
                System.out.println(">>>>>>>");
            }
        }

    }


    public void Inputoutput() throws FileNotFoundException {


        InputStream inputStream = new FileInputStream("");
    }


    public static String ceshi(String str) throws FileNotFoundException {

        CountDownLatch countDownLatch = new CountDownLatch(3);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(""));


        //自己定义线程池
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5, 5L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));

        String[] _arry = str.split(" ");
        String result = "";

        for (int i = _arry.length - 1; i >= 0; i--) {
            String.valueOf(str.charAt(i)).equals(" ");
            result = result + _arry[i] + " ";
        }
        return result;
    }
}



