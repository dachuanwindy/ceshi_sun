package com.spring.ioc;

import org.springframework.context.annotation.*;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/7/8 12:38
 */
@Configuration
@ComponentScan(value = {"com.spring"})
@EnableAspectJAutoProxy
 public class AppConfig {

    @Bean
    public UserService userService() {

        System.out.println("初始化成功");
        return new UserService();
    }

}
