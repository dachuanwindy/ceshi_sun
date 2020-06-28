package Test_1;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarriarTest {

    public static void main(String[] args) {

        final CyclicBarrier c = new CyclicBarrier(2, new A());

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("CyclicBarrier的线程" + "    线程ID =" + Thread.currentThread().getId());
            }
        }).start();

        try {
            c.await();
            c.reset();
            System.out.println(" reset 之后的值为：" + c.getParties());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("输出值为" + 2 + "    " + Thread.currentThread().getId());
    }
}


class A implements Runnable {


    @Override
    public void run() {
        System.out.println("这个我应该是输出  3");
    }
}

class Treemap_study {

    static CountDownLatch countDownLatch = new CountDownLatch(5);

    public static void main(String[] args) throws IOException, InterruptedException {

        String uuid = UUID.randomUUID().toString().replace("-", "");

        System.out.println(uuid);

        for (int i = 0; i < 5; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println("当前线程号为" + "  " + Thread.currentThread().getName().toString());
                        countDownLatch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }


        for (int j = 0; j < 3; j++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("现在是后半段线程执行" + Thread.currentThread().getName() + "====" + Thread.currentThread().getId() + "  >>>>>>  " + Thread.currentThread().getState());
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }
        System.out.println("线程结束。。。。。");

    }

}


class ThreadLocal_stdy {

    private ThreadLocal<Integer> threadLocal_int = new ThreadLocal<Integer>();


    public int getN() {

        threadLocal_int.set(12);

        return threadLocal_int.get();
    }


    public  static  void main(String [] args){

        for (int i=0;i<3;i++){

            // 将threadlocal 的值传入到这个每个线程中，这样就能保证每个线程中的值是一样的，每个线程修改各自的值，是不会影响到每个线程的。
            // threadlocal 就起到了这个作用。

            new  Thread(new Runnable() {

                private  ThreadLocal_stdy threadLocal_stdy;

                @Override
                public void run() {

                    System.out.println();

                }
            }).start();

        }

    }

}