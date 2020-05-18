package inspur.Thread_study.threadStop;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 线程中断方法
 * @date 2020/5/16 18:55
 */
public class ThreadStropTest {

    public static void main(String[] args) throws InterruptedException {


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.interrupted()) {
                        break;
                    }
                    System.out.println("哈哈哈哈哈");
                }
            }
        });
        thread.start();

        Thread.State state = thread.getState();


        Thread.sleep(20);

        thread.interrupt();
    }
}
