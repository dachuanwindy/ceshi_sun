package Test_1;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description:   threadLocal 真正的原理是： 一个thread 维护一个threadLocalMap， 这个Map的key==当前对象；
 * @Author: sunfch
 * @Date: 2019/1/6 18:36
 * @Param:
 * @Return:
 *
 * threadLocal 容易造成线程泄漏，如何防止线程泄漏
 *
 *
 */
@Slf4j
public class ThrealLocal_study {

    public static ThreadLocal<Map<String, String>> threadLocal = new ThreadLocal<>();


    public void setvalue() {
        Map<String, String> param = new HashMap<>();
        param.put("sunf", "sunfch");
        param.put("threadName", Thread.currentThread().getName());
        threadLocal.set(param);
    }

    public static void main(String[] args) {
        ThrealLocal_study study = new ThrealLocal_study();
        study.setvalue();
        Map<String, String> result = threadLocal.get();
        System.out.println(result.toString());


        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        lock.readLock();

        new Thread(new Runnable() {

            @Override
            public void run() {
             //   threalLocal_study.setvalue();
                Map result1 = threadLocal.get();
                System.out.println(result1.toString());
            }
        }).start();


        Map result3 = threadLocal.get();
        log.info("从主线程获得的数据是====>" + result3.toString());

    }

    public void method4( String id) {

        ExecutorService service= new ThreadPoolExecutor(3, 3, 4, TimeUnit.SECONDS, new LinkedBlockingDeque<>());

        service.execute(new Runnable() {
            @Override
            public void run() {
                log.info("输出Key"+id);
            }
        });
    }

}
