package shejimoshi.Proxy_moshi.proxy_jdk8;

import org.jboss.netty.bootstrap.ServerBootstrap;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/4/12 12:21
 */

public class MyCalculatorTestMain {

    public static void main(String[] args) {

//
//        ProxyClient proxyClient = new ProxyClient();
//
//        Calculator target11 = (Calculator) proxyClient.getTarget11();
//
//        Integer add = target11.add(11, 12);
//
//        target11.dev(11, 12);
//        System.out.println(add);

        //   Calculator proxyCli = (Calculator) ProxyClient.getProxyCli(Calculator.class, MyCalculator.class);
        //   proxyCli.add(11, 22);

        //        try {
//            MyCalculator myCalculator = MyCalculator.class.newInstance();
//          //  Integer add = myCalculator.add(11, 22);
//          //  System.out.println(add);
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }

        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);


        //反射实现对象及对象中的方法,必须要知道方法名字;
        Method method = null;
        try {
            method = MyCalculator.class.getMethod("add", Integer.class, Integer.class);
            Object result = method.invoke(MyCalculator.class.newInstance(), 11, 22);
            System.out.println(result);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.bind();
        serverBootstrap.bindAsync();




    }
}

class MainB{
    public static void main(String[] args) {
        try {
            String name = MyCalculator.class.getName();
            Method method1 = Class.forName(MyCalculator.class.getName()).getMethod("add",Integer.class,Integer.class);
            Object invoke = method1.invoke(MyCalculator.class.newInstance(), 11, 22);
            System.out.println(invoke);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}