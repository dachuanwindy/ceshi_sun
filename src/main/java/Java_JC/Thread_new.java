package Java_JC;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Thread_new {

    public static int ianliang2 = 12;

    public static void main(String[] args) throws InterruptedException {
//   duoxianchengrenwu T1 =new duoxianchengrenwu();
//   duoxianchengrenwu T2 =new duoxianchengrenwu();
//
//    System.out.println("任务开始执行了");
//     T1.start();
//     T2.start();
//    }
        //    new Thread(new Thread_Runnable(new ticket())).start();
        //  new Thread(new Thread_Runnable(new ticket())).start();

   /*     leaf leaf =new leaf();
      Object o=  leaf.ddsd();
      o.toString();
      o.hashCode();
    boolean ff=  o.equals("485".toString());*/

        // o.notify();
        String S = "qwertyuiop";

        System.out.println(S.replace("yu", "sunsunsusn"));



    }

    class duoxianchengrenwu extends Thread {

        public duoxianchengrenwu() {
        }

        public void run() {


            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread concurrent = Thread.currentThread();
                System.out.println("+++++" + i + "  当前线程为 " + concurrent);
            }

        }

    }
}

class Thread_Runnable implements Runnable {
    private ticket ticket1;
    private ticket t2;

    public Thread_Runnable(ticket t111) {
        this.ticket1 = t111;


    }

    public synchronized void run() {

        System.out.println("===>>>" + Thread.currentThread());
        ticket1.ticket2();
    }


}


class ticket {
    private final int i = 10;

    public ticket() {

    }

    public void ticket2() {

        for (int i = 0; i < 10; i++) {
            System.out.println("卖过车票了");
        }
    }

}

class ceshi3 {


    public ceshi7 cs6;

    public ceshi3(ceshi7 t33) {
        this.cs6 = t33;
    }

    public void ceshi5() {
        System.out.println("ceshi5");
    }

}

class ceshi7 {
    public void maipiao() {
        System.out.println("开始买火车了 ceshi6");
    }


    void method() {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.get();
        threadLocal.set("");
    }

}

class Rocket {

    Rocket() {
        System.out.println("火箭");
    }

    Rocket(int j) {
        System.out.println("火箭+" + j);
    }
}

class leaf {
    int i = 0;

    leaf ddsd() {
        i++;
        return this;

    }
}

