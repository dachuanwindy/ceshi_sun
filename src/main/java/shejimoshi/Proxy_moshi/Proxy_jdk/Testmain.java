package shejimoshi.Proxy_moshi.Proxy_jdk;

import shejimoshi.Proxy_moshi.Soucerbale;
import shejimoshi.Proxy_moshi.Source;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author sunfch
 * @create 2018-11-03 22:59
 * @desc JDK 动态代理模式是如何实现的
 **/
public class Testmain {

    public static void main(String[] args) {
        final Soucerbale soucerbale = new Source();

        ClassLoader classLoader = soucerbale.getClass().getClassLoader();
        Soucerbale proxy = (Soucerbale) Proxy.newProxyInstance(soucerbale.getClass().getClassLoader(), soucerbale.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代理方法之前。。。。。。。。。。。");
                        Object returnvalue = method.invoke(soucerbale, args);
                        return returnvalue;
                    }
                });
        proxy.method1();
    }
}
