package Test_1.semphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 信号量功能演示
 * @date 2020/3/25 09:47
 */
public class SemaphoreTest {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(40);
        // 只能5个线程同时访问
        final Semaphore semp = new Semaphore(5);
        // 模拟20个客户端访问
        for (int index = 0; index < 20; index++) {
            final int NO = index;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        // 获取许可
                        semp.acquire();
                        System.out.println("Accessing: " + NO);
                        //模拟实际业务逻辑
                        Thread.sleep((long) (Math.random() * 10000));
                        // 访问完后，释放
                        semp.release();
                    } catch (InterruptedException e) {
                    }
                }
            };
            executorService.execute(run);
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println(semp.getQueueLength());
        // 退出线程池
        executorService.shutdown();
    }

}
