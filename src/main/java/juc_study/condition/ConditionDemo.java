package juc_study.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunfch
 * @version V1.0
 * @Description: JUC  条件
 * @date 2020/6/15 09:23
 */
public class ConditionDemo {

    public static void main(String[] args) {
        System.out.println("并发的条件, 通过这个控制器,可以实现");

        DataPrint dataPrint = new DataPrint();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                dataPrint.printA();
            }).start();

            new Thread(() -> {
                dataPrint.printB();
            }).start();

            new Thread(() -> {
                dataPrint.printC();
            }).start();
        }
    }

}


class DataPrint {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    private volatile int num = 1;

    /**
     * @description: 打印A
     * @author sunfch
     * @date 2020/6/15 10:10
     */
    public void printA() {

        lock.lock();
        try {
            //当 条件没有达到的时候等待任务
            // 官网建议:问什么用while();
            while (num != 1) {
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "AAAAA");
            //唤醒第二个线程执行任务
            num=2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * @description:
     * @author sunfch
     * @date 2020/6/15 10:23
     */
    public void printB() {

        lock.lock();
        try {
            //当 条件没有达到的时候等待任务
            // 官网建议:问什么用while();
            while (num != 2) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "BBBBB");
            //唤醒第二个线程执行任务
            num=3;
            condition3.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * @description: 当条件没有满足的时候, 就执行这个任务
     * @author sunfch
     * @date 2020/6/15 10:23
     */
    public void printC() {

        lock.lock();
        try {
            //当 条件没有达到的时候等待任务
            // 官网建议:问什么用while();
            while (num != 3) {
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "CCCC");
            //唤醒第二个线程执行任务
            num=1;
            condition1.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

