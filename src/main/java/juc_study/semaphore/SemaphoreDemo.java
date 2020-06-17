package juc_study.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 信号量
 * @date 2020/6/15 06:50
 */
public class SemaphoreDemo {


    public static void main(String[] args) throws InterruptedException {
        System.out.println("信号量");

        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到了车位");
                    TimeUnit.SECONDS.toSeconds(2);
                    System.out.println(Thread.currentThread().getName() + "s释放了车位");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }


    }
}
