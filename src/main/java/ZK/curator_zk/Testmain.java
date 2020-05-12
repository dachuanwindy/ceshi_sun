package ZK.curator_zk;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sunfch
 * @create 2018-10-24 23:04
 * @desc 常规多线程引发线程安全问题
 **/
public class Testmain {

    public static  int count =0;
    public static void main(String[] args) throws InterruptedException {

        final CountDownLatch countDownLatch = new CountDownLatch(100);
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    countDownLatch.countDown();
                    System.out.println("当前订单号是" + GeneratorOder());
                }
            });

        }
        countDownLatch.await();
        executor.shutdown();
    }

    public static String GeneratorOder() {
//        String uuid = UUID.randomUUID().toString();
        count++;
        return count+"";

    }
}
