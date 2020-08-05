package com.spring.aop;

import com.spring.annotation.MyAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/7/17 23:55
 */

@Component
/**通过这个注解能实现自己定义好的bean被扫描注入@ComponentScan(value = {"com.spring.aop"})*/
@Aspect
public class AopConfig {

    /**
     * @description: 声明切面路径
     * @author sunfch
     * @date 2020/7/18 00:56
     */
    @Pointcut("execution(* com.spring.dao.AppService.test()))")
    public void pointCut() {
    }


    /**
     * @description: 关注切点
     * @author sunfch
     * @date 2020/7/18 00:56
     */
    @Before("pointCut()")
    public void beforeTest() {
        System.out.println("这个是切面的前置方法");
    }

    @AfterThrowing(value = "pointCut()")
    public void throwException() {
        System.out.println("异常抛出的----->throw exception");
    }

    /**
     * @description: 中间处理器
     * @author sunfch
     * @date 2020/7/18 09:55
     */
    @Around("pointCut()")
    public Object sayAround(ProceedingJoinPoint pjp) {
        Object proceed = null;
        System.out.println("注解类型环绕通知..环绕前");
        long time2 = System.currentTimeMillis();
        try {
            Method method = ((MethodSignature) pjp.getSignature()).getMethod();

            boolean annotationPresent = method.isAnnotationPresent(MyAnnotation.class);
            System.out.println("是否有自己想要的注解在上面");

            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);

            Annotation[] annotations = ((MethodSignature) pjp.getSignature()).getMethod().getAnnotations();


            proceed = pjp.proceed();
            System.out.println(method);

        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("注解类型环绕通知..环绕后,执行时间" + (System.currentTimeMillis() - time2));
        return proceed;
    }


}
