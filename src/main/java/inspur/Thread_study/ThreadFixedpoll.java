package inspur.Thread_study;

import com.mysql.jdbc.TimeUtil;

import java.util.concurrent.*;

public class ThreadFixedpoll {
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(() -> new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(5000);
                        System.out.println();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        }

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        poolExecutor.setCorePoolSize(4);

    }
}