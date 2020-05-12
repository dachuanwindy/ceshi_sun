package inspur.BXD_JCSP.Bixiangdong_study.Thread_study.Thread2;

public class Tickt extends Thread {

    private static int ticke_number = 10000;

    public void run() {

        while (true) {
            if (ticke_number > 0) {
                System.out.println("线程run 方法" + Thread.currentThread().getName() + ".......>>" + ticke_number--);
            }
        }
    }
}

class TestThread {
    public static void main(String[] args) {
        Tickt tickt1 = new Tickt();
        Tickt tickt2 = new Tickt();
        Tickt tickt3 = new Tickt();
        tickt2.start();
        tickt1.start();

        tickt3.start();


    }
}
