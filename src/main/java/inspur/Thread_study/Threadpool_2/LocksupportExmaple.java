package inspur.Thread_study.Threadpool_2;

import java.util.concurrent.locks.LockSupport;

public class LocksupportExmaple {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("!!!!");
            welcomettast ff = new welcomettast();
            Thread welcom = new Thread(ff);
            welcom.start();
            String name = welcom.getName();
            System.out.println("当前线程的名字是" + name);
            LockSupport.unpark(welcom);
        }
    }
}


class welcomettast1 implements Runnable {
    @Override
    public void run() {
        LockSupport.park();
        System.out.println("我要学习多线程");
        Thread.currentThread();
        try {
            Thread.sleep(1000);
            Thread.interrupted();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
