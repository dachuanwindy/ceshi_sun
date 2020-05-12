package inspur.BXD_JCSP.Bixiangdong_study.Thread_study.Thread;

/*每次执行的结果不一样原因是： 第一，两个线程都在抢CPU资源，CPU分配资源的顺序是随机的，这样导致结果不同
其实是CPU将执行划分为时间片段，抢占每个时间片段的控制权，（我理解是这样的。待查阅更正--）
*
* */
public class Thread1 extends Thread {
    Thread1(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("多线程任务输出----" + Thread1.currentThread().getName());
        }
    }
}

class Test {
    public static void main(String[] s) {
        System.out.println("多线程事例");
        for (int i = 0; i < 100; i++) {
            System.out.println("··················");
        }
        Thread1 t = new Thread1("sunfengchuan ");
        t.start();

        Thread1 t2 = new Thread1("ceshi==");
        t2.start();
    }
}
