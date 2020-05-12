package inspur.JVMTst;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/3/17 14:37
 */
public class test {
    public static void main(String[] args) {
        Thread a = new Thread(new A(true));
        Thread b = new Thread(new A(false));
        a.start();
        b.start();

        ReentrantLock reentrantLock = new ReentrantLock();

        ReentrantLock reentrantLock1 = new ReentrantLock();
        reentrantLock.lock();

    }


}

class A implements Runnable {

    static final Object aaa = new Object();
    static final Object bbb = new Object();

    private boolean flag;

    A(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {

        if (flag) {
            synchronized (aaa) {
                try {
                    Thread.sleep(55);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (bbb) {
                    System.out.println("bbb");
                }
            }
        } else {
            synchronized (bbb) {
                synchronized (aaa) {
                    System.out.println("aaa");
                }
            }
        }



    }


}
