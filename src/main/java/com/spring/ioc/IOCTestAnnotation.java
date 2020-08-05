package com.spring.ioc;

import com.spring.dao.AppService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/7/8 12:37
 */
public class IOCTestAnnotation {

    public static void main(String[] args) throws Exception {

        //这个地方通过注解方式实现spring的bean的注入
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = (UserService) context.getBean("userService");
        userService.test();

        AppService bean = context.getBean(AppService.class);
        bean.test();

    }


}
