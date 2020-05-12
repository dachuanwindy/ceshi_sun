package shejimoshi.Proxy_moshi;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/*
 *  第一步：代理模式首先是有接口，
 *
 *  第二步: 用一个类实现原来的接口方法，然后
 *
 *
 *
 *
 * **/
public class TestProxy {

    public static void main(String[] args) {
        System.out.println("代理模式");
        Soucerbale soucerbale = new Proxy();
        soucerbale.method1();

    }
}


/**
 * @Description: 代理模式 分为两种一种是实现： JDK自带的【针对接口实现】  ，CGLIB 动态代理（不针对接口）
 * @Author: sunfch
 * @Date: 2019/2/19-16:38
 * @Param:
 * @Return:
 */
class realObject {
    public void sayhello() {
        System.out.println(" 真是方法");
    }
}

class cglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return null;
    }
}

