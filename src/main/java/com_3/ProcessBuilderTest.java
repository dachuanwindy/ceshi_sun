package com_3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author sunfch
 * @version V1.0
 * @Description: spring容器框架启动类 监控对象
 * <p>
 * 实现断点监控对象, 监控容器的加载,
 * 监控循环依赖
 * @date 2019/9/1 17:42
 */
public class ProcessBuilderTest {

    public static void main(String[] args) throws IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");

        System.out.println("======" + context.toString());

        StudentBean studentBean = context.getBean(StudentBean.class);
        String sun_time = studentBean.message("sun time");
        System.out.println("输出的bean 是" + sun_time);

        StudentBean2 studentBean2 = new StudentBean2();
        studentBean2.getStudentBean();

    }
}
