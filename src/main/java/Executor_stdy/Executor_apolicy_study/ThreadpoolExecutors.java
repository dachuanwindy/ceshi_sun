package Executor_stdy.Executor_apolicy_study;

import java.util.concurrent.*;

/**
 * @Description: 这个类非常重要，是线程池的核心内容，
 * @Author: sunfch
 * @Date: 2019/2/21-15:55
 * @Param:
 * @Return:
 */
public class ThreadpoolExecutors {

    public static void main(String[] args) {

        RejectedExecutionHandler handler = new MyPolicy();
        RejectedExecutionHandler handler1 = new ThreadPoolExecutor.AbortPolicy();

        /**
         * @Description: 自己创建的线程池
         * @Author: sunfch
         * @Date: 2019/2/21-15:53 
         * @Param: [args]
         * @Return: void
         */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
                10, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<>(1000), handler);
        for (int i = 0; i < 50; i++) {
            executor.execute(new Worker());
        }

        CompletableFuture future = new CompletableFuture();

        future.join();
     }

}


/**
 * @Description: 自己的线程业务逻辑
 * @Author: sunfch
 * @Date: 2019/2/21-16:30
 * @Param:
 * @Return:
 */
class Worker implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "is running");
    }
}

/**
 * @Description: 自己实现丢弃策略
 * @Author: sunfch
 * @Date: 2019/2/21-16:22
 * @Param:
 * @Return:
 */
class MyPolicy implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        throw new RejectedExecutionException();
    }
}


class ceshi3 {
    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(20);

        concurrentHashMap.put("dd", "dd");
    }
}