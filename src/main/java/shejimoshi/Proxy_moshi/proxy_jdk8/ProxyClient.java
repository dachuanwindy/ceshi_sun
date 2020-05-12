package shejimoshi.Proxy_moshi.proxy_jdk8;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 代理客户端, 这个地方就相当于再次对Proxy进行了封装,方便后面使用; 这个地方理解有误:
 * @date 2020/4/12 12:26
 */

public class ProxyClient<T> {


    private static Object target;

    static <T> T getProxyCli(Class<?> targetClass,Class<?> targetClassImpl) {

        try {
            Object o = targetClassImpl.newInstance();
            target = o;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Object o2 = Proxy.newProxyInstance(targetClass.getClass().getClassLoader(), targetClass.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object invoke = method.invoke(target, args);
                return invoke;
            }
        });

        return (T) o2;

    }

    Object getTarget11() {

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object invoke = method.invoke(target, args);
                return invoke;
            }
        });

    }
}
