package ZK.curator_zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sunfch
 * @create 2018-10-24 23:03
 * @desc zookeeper实现分布式锁
 **/
public class DistributeLock {

    public static int count = 0;

    static RetryPolicy retryPolicy = new ExponentialBackoffRetry(3000, 3);
    static final CuratorFramework client = CuratorFrameworkFactory.builder().connectString("127.0.0.1:2181").retryPolicy(retryPolicy).build();

    public static void main(String[] args) throws InterruptedException {

        client.start();
        final InterProcessMutex lock = new InterProcessMutex(client, "/qqqq");
        final CountDownLatch countDownLatch = new CountDownLatch(100);
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {

                    try {
                        lock.acquire();
                        countDownLatch.countDown();
                        System.out.println("当前订单号是" + GeneratorOder());
                        lock.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });

        }
        countDownLatch.await();
        executor.shutdown();
    }

    public static String GeneratorOder() {
//        String uuid = UUID.randomUUID().toString();
        count++;
        return count + "";

    }
}
