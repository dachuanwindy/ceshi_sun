package com.spring;

import com.spring.dao.AppService;
import com.spring.ioc.AppConfig;
import com.spring.ioc.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author sunfch
 * @version V1.0
 * @Description:
 *
 * 总结: 这个是AOP动态代理实现
 * 技术实现:
 * 第一:首先引入Jar包,  设置开启aspectJ动态代理
 * 第二:定义切面,定义切点;
 * 第三:编写前置处理,后置处理,中间处理等相关逻辑程序,扩展:这里也可以定义自己的注解,然后实现这个代理
 * 第四:调用实现即可;
 *
 * 源码分析:
 *  第一:创建动态对象,在初始化的时候,就已经创建了动态代理对象;
 *  第二:实现的点,在BeanPostProcessor 调用之前,创建代理对象
 *  DefaultAopProxyFactory 这个是最终实现的方式,代理类实现的方式,要是接口,就走JDK, 要是具体类就用cglib实现;
 *
 * @date 2020/7/16 14:53
 */
public class SpringMain {

    public static void main(String[] args) throws Exception {

        //这个地方通过注解方式实现spring的bean的注入
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = (UserService) context.getBean("userService");
        userService.test();
        AppService bean = context.getBean(AppService.class);
        bean.test();
    }
}
