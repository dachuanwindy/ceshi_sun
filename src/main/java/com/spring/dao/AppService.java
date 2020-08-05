package com.spring.dao;

import com.spring.annotation.MyAnnotation;
import org.springframework.stereotype.Service;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/7/18 00:41
 */
@Service
public class AppService {

    @MyAnnotation
    public String test() throws Exception {
        System.out.println("service方法");
        throw new Exception("抛出异常");
        //  return "AOP生效了吗";

    }
}
