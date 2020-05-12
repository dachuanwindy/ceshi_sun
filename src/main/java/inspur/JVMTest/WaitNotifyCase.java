package inspur.JVMTest;

import java.util.concurrent.TimeUnit;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/3/23 00:00
 */
public class WaitNotifyCase {
    public static void main(String[] args) {
        final Object lock = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread A is waiting to get lock");
                synchronized (lock) {
                    try {
                        System.out.println("thread A get lock");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("thread A do wait method");
                        //  这个地方释放了线程，也就把锁给释放掉了，给了B 线程执行的机会
                        lock.wait();
                        System.out.println("wait end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread B is waiting to get lock");
                synchronized (lock) {
                    System.out.println("thread B get lock");
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 这个地方也是将当前线程唤醒，接着执行A操作。
                    lock.notify();
                    System.out.println("thread B do notify method");
                }
            }
        }).start();
    }
}
