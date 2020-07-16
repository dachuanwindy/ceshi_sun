package com.spring.ioc;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/7/8 12:38
 */
@Configuration
@Import(value = {UserService.class})
public class AppConfig {

//    @Bean
//    public UserService userService() {
//
//        System.out.println("初始化成功");
//        return new UserService();
//    }

}
