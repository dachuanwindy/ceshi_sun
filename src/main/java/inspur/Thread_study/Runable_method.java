package inspur.Thread_study;

public class Runable_method implements Runnable {

    public Runable_method() {
    }

    @Override
    public void run() {
        for (int a = 0; a < 5; a++) {
            System.out.println("输出子线程" + Thread.currentThread().getId());
        }
    }
}
