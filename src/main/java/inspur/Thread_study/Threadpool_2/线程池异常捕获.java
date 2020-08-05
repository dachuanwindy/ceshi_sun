package inspur.Thread_study.Threadpool_2;

import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/7/30 16:13
 */
public class 线程池异常捕获 {

    /**
     * 技术总结:
     * 1.线程池捕获子线程的异常,Future 进行捕获; future.get()进行捕获;
     * 2.注意这个get().会发生阻塞;
     */
    public static void main(String[] args) {
        int size = 5;
        /**
         * 线程池推荐使用Executors去创建，而是通过ThreadPoolExecutor的方式，
         * 这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
         * 说明：Executors各个方法的弊端：
         * 1）newFixedThreadPool和newSingleThreadExecutor:主要问题是堆积的请求处理队列可能会耗费非常大的内存，甚至OOM。
         * 2）newCachedThreadPool和newScheduledThreadPool:主要问题是线程数最大数是Integer.MAX_VALUE，可能会创建数量非常多的线程，甚至OOM。
         */
        // 此处没有使用ThreadPoolExecutor的后两个参数，则使用的是默认线程工厂和默认的拒绝策略(AbortPolicy--抛出RejectedExecutionException)
        ThreadPoolExecutor
                executor = new ThreadPoolExecutor(2, size, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(size));
        executor.allowCoreThreadTimeOut(true);
        try {
            for (int i = 0; i < size; i++) {
                try {
                    final int cur = i;

                    Future<?> future2 = executor.submit(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("----->");
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    //  future2.get();
                    System.out.println("下一个任务执行");
                    // Future获取子线程异常，外层能捕获future包装后的异常
                 /*   Future<?> future = executor.submit(new Runnable()
                            // execute执行中的异常能抛出,但是不能被外层中的try...catch...捕获
                            // executor.execute(new Runnable()
                            // 只用submit，不获取submit的返回值-future，有异常也不会抛出
                            // executor.submit(new Runnable()
                    {

                        @Override
                        public void run() {
                            Thread.currentThread().setName("Thread-" + cur);
                            System.out.println("Current value: " + cur);
                            System.out.println(Thread.currentThread().getName());

                            if (cur < 1) {
                                return;
                            } else {
                                Integer.parseInt("abc");
                            }
                        }
                    });*/
                    // future.get();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Task exception.");
                }
            }
        } finally {
            executor.shutdown();
        }
    }

}
