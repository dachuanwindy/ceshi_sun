package Test_1.countdownLatch;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/3/28 16:34
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        new Thread(new Action(countDownLatch, "sunfengchuan")).start();
        new Thread(new Action(countDownLatch, "保罗")).start();
        new Thread(new Action(countDownLatch, "科比")).start();
        new Thread(new Action(countDownLatch, "安东尼")).start();
        countDownLatch.countDown();
        countDownLatch.countDown();
        countDownLatch.countDown();


    }
}

class Action implements Runnable {

    private CountDownLatch countDownLatch;
    private String name;

    Action(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    @Override
    public void run() {

         try {
            countDownLatch.await();
            System.out.println(name + "开始有动作了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}