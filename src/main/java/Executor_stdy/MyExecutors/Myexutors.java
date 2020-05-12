package Executor_stdy.MyExecutors;

import java.util.concurrent.*;

/**
 * @Description: 自己实现线程池，好处：让同学们更加明确线程池规则，避免资源耗尽的风险
 * @Author: sunfch
 * @Date: 2019/2/28-10:12
 * @Param:
 * @Return:
 */
public class Myexutors {
    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(3);
        ThreadFactory factory = r -> new Thread(r, "test-thread-pool");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 5,
                0L, TimeUnit.SECONDS, queue, factory, new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 1000; i++) {
            executor.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + ":执行任务");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

}
