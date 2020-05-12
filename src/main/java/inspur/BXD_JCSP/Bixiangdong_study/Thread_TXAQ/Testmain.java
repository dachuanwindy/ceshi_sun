package inspur.BXD_JCSP.Bixiangdong_study.Thread_TXAQ;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Testmain {
    public static void main(String[] args) throws InterruptedException {

/*        System.out.println("线程安全通讯问题····");

        Resource resource = new Resource();
        Pro pro = new Pro(resource);
        Thread thread = new Thread(pro);
        thread.start();*/
// 线程join方法演示

        Thread_join thread_join = new Thread_join();
        Thread t = new Thread(thread_join);
        Thread t2 = new Thread(thread_join);
        t.start();

        t2.start();
        t.join();
        t2.join();
        for (int i = 0; i < 80; i++) {
            System.out.println(Thread.currentThread().getName() + ">>>>>" + i);

        }

        System.out.println("over");


    }
}

class Resource {
    private String name;
    private int count = 1;
    boolean flag = false;

    public synchronized void set(String name) {
      /*  if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("生产的产品是" + name + "编号是" + count++);
            flag = true;
            this.notify();
        }*/
    }

    public synchronized void show() {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("====消费产品" + name + ">>>>>" + count++);
            flag = true;
            this.notify();
        }
    }
}

class Pro implements Runnable {

    private Resource r = new Resource();

    public Pro(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.set("shangpin======");
        }

    }
}

class Consumer implements Runnable {
    Resource r = new Resource();

    public Consumer(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        if (r.flag) {
            r.show();
        }
    }


}


class Resource11 {
    private String name;
    private int count = 1;
    boolean flag = false;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void set(String name) {
        try {
            while (flag) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("生产的产品是" + name + "编号是" + count++);
            flag = true;
            condition.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void show() {
        try {
            while (!flag) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("====消费产品" + name + ">>>>>" + count++);
            flag = true;
            condition.signalAll();
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }
}


class Thread_join implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"====" +i);
        }
    }
}
