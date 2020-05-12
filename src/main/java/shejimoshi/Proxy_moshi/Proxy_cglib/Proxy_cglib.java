package shejimoshi.Proxy_moshi.Proxy_cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author sunfch
 * @create 2018-11-03 23:20
 * @desc cglib 动态代理实现
 **/
public class Proxy_cglib implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return null;
    }
}
