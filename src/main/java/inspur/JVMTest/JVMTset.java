package inspur.JVMTest;

import java.lang.ref.SoftReference;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: Java JVMtest
 * @Author: sunfch
 * @Date: 2019/1/31-10:53
 * @Param:
 * @Return:
 */
public class JVMTset {

    static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "HelloWord");

    static CountDownLatch countDownLatch = new CountDownLatch(4);

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        SoftReference<String> weakReference = new SoftReference<String>(new String("Misout的博客"));
        System.gc();
        if (weakReference.get() == null) {
            System.out.println("weakReference已经被GC回收");
        }

        countdownLatchtest();
    }

    public static void countdownLatchtest() throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 6; i++) {

            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("开始减数==" + countDownLatch.getCount());
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("抢占资源的地方=====");
                }
            });
            countDownLatch.countDown();
            System.out.println("执行最后的方法=============");

        }
        System.out.println("执行最后的方法");
        System.out.println();

    }

    public static void conditionTest() throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        condition.await();
        condition.signal();

    }


}
