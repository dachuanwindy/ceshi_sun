package inspur.BXD_JCSP.Bixiangdong_study.Thread_TX;

/* *  多线程之间的同步问题
 *wait()
 * notify();
 * notifyall();
 * 这些方法都使用在同步方法中synchronize中，要对持有对象的 “锁” 进行工作，所以一定要存在 同步块 同步函数等同步中···
 *
 *
 * 为什么锁在Object中，synchronized 中有这个锁，
 *
 * 很重要的一句话： wait() notify() 必须操作在同一个线程对象中。。。。。
 *
 *
 *
 *
 *
 * */
public class Test {

    public static void main(String[] args) {

        System.out.println("==============");
        Res res = new Res();
        Input input = new Input(res);
        Output output = new Output(res);
        Thread t1 = new Thread(input);
        Thread t2 = new Thread(output);
        t1.start();
        t2.start();
    }
}

class Res {
    String name;
    String age;
    boolean flag = false;

}

class Input implements Runnable {

    private Res res;

    Input(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        int x = 0;
        while (true) {
            synchronized (res) {


                if (res.flag) {
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (x == 0) {
                        res.name = "zhangsan";
                        res.age = "15";
                    } else {
                        res.name = "李四";
                        res.age = "25";
                    }
                    x = (x + 1) % 2;
                    res.flag = true;
                    res.notify();
                }
            }
        }
    }
}

class Output implements Runnable {
    private Res res;

    Output(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (res) {

                if (!res.flag) {
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(">>>>>" + res.name + "======" + res.age);
                    res.flag = false;
                    res.notify();
                }
            }
        }
    }
}


/**
 *
 *
 *
 * */