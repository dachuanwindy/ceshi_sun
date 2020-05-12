package inspur;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Task("1"));
        t.start();
        // 线程中断的作用
        t.interrupt();
    }

    static class Task implements Runnable {
        String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("first :" + Thread.interrupted());
            System.out.println("second:" + Thread.interrupted());
            System.out.println("task " + name + " is over");
        }
    }
}

