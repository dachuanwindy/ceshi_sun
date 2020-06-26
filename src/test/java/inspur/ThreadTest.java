package inspur;


/**
 * @author sunfch
 * @description: 线程学习 ,通过中断优雅的停掉线程
 * @date 2020/6/26 10:41
 */
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

    /**
     * @description: 通过中断优雅的停掉线程
     * @author sunfch
     * @date 2020/6/26 10:41
     */
    public static void method() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            volatile boolean interrupted = Thread.interrupted();

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());

                while (true) {
                    System.out.println("--------------");
                    while (interrupted) {
                        System.out.println("别人中断了我,我退出了程序");
                        return;
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println("中断之后,,,,,,");
                        // interrupted = true;
                    }
                }
            }
        }, "sun");
        thread.start();
        Thread.sleep(1000L);
        thread.interrupt();
        System.out.println(Thread.currentThread().getName());
    }
}

