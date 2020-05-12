package inspur.BXD_JCSP.Bixiangdong_study.Thread_JX;

/**
 * 1.最基本的凡是是继承thread 或者 runable
 * <p>
 * 第二种简单写法： new thread(){ 在这里面实现 run 方法}.start();   // 匿名函数方式，这种方式比较简单，
 * <p>
 * 第三种简单写法： Runable runable = new  Runable(){ 实现run 方法 }；
 * new Threaa(runable).start();  //也是隐式函数的另一种写法
 * <p>
 * <p>
 * 常用的方法中有：start()；//启动线程， 线程必须的方法
 * join()；//抢占线程权利， thread1.join（），此时只能等到线程1 执行完之后才能执行其他线程
 * yeild();// 遇到这种情况时，让出线程，把执行权利让给其他线程；
 * interrupt();//当没有办法让冻结状态唤醒时，这个时候需要对此线程进行清除。
 * await(); //等待进程
 * signal(); //唤醒进程
 * sleep(); //等待线程，让线程等待一定时间自己启动运行；
 * <p>
 * 第二大知识点：：线程锁： synchronized() 与 lock
 * <p>
 * 同步代码块：使用这个时候，线程将会把这段代码进行锁定，等运行完之后，将此代码进行解锁，自动进行解锁。
 * 线程共享数据：这些代码需要对其进行 上锁或者同步。
 * <p>
 * sychronized 也可以修饰方法体：这样就是程序阅读性提高。原理是一样的。
 */
public class Testmain {

    public static void main(String[] args) {
        System.out.println("----线程总结章节----");

        new Thread() {

            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "====" + i);
                }
            }
        }.start();


        for (int i = 1; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + ">>>>" + i);
        }


//        方式三
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 60; i++) {

                    System.out.println(Thread.currentThread().getName() + "<<<<>>>>" + i);
                }
            }
        };
        new Thread(r).start();
    }
}
