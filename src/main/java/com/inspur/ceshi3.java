package com.inspur;

import java.sql.SQLException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


class c {
    public synchronized void cc() {
        System.out.println("cc");
    }
}

public class ceshi3 extends c {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

//        List list = new ArrayList();
//        List list1 = new LinkedList();
//        List list2 = new Vector();
//
//        String str = "123";
//        try {
//            int a = Integer.parseInt(str);
//            a=a+1;
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//        }

        synchronized (new Object()) {
            ceshi3 ceshi3 = new ceshi3();
            ceshi3.cc();
        }


    }


}

class Test {
    private static Test TEST = null;

    public static void main(String args[]) {
        TEST = new Test();
        TEST = null;
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(TEST);
    }

    @Override
    public void finalize() throws Throwable {
        System.out.println("要死了要死了要死了!");
    }
}

class ThreadPoolTest {

    public static void createThreadPoll() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10), new ThreadPoolExecutor.CallerRunsPolicy());

    }

    // 实现自己的一个线程工厂
    class MyThreadPoolFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            // 这里可以设置线程名称与线程号
            Thread thread = new Thread(r);

            return thread;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10), new ThreadPoolExecutor.CallerRunsPolicy());

        executor.execute(new JobTask());
        executor.shutdown();
        executor.shutdownNow();
        boolean b = executor.awaitTermination(2222, TimeUnit.SECONDS);


    }

    static class JobTask implements Runnable {

        @Override
        public void run() {
            System.out.println("执行我的业务逻辑");
        }
    }
}
/**
 *
 * 1 关闭线程池 shutdownNow()方法,执行了三个方法
 *
 *
 *
 *
 *
 * */