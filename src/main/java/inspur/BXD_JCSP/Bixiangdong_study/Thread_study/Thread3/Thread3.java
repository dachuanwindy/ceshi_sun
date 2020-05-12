package inspur.BXD_JCSP.Bixiangdong_study.Thread_study.Thread3;

/**
 * 编写多线程的另一种步骤：
 * 1 继承 Runable
 * 2 实现run 方法：这是是将自己要执行的业务逻辑在该方法中实现
 * 3 实例化runnable对象
 * 4 创建线程，并将线程中的添加实例化的runable对象
 * 5.启动线程
 * <p>
 * <p>
 * <p>
 * thread 与Runable 之间的区别
 * 好处： 避免了继承的局限性，Runable 比较常用，建议使用runable!
 * <p>
 * <p>
 * <p>
 * 多线程最主要的是 安全问题，卖票卖出了负数是怎么回事
 * <p>
 * java对多线程安全问题在于： 共享数据在执行的时候容易，一个线程还没执行完成，另外一个线程开始启动执行，造成数据安全问题
 * <p>
 * 解决方案： java对于对县城数据安全问题，提供了专业的解决方案； syngnieze
 * <p>
 * 解決多线程运行问题首先要明确：
 * 1.哪些是多线程运行程序，
 * 2.哪些共享数据
 * 3.明确多线程中 哪些线程执行操作共享数据
 */
public class Thread3 implements Runnable {
    private int tickt_number = 100;

    @Override
    public void run() {
        Object object = new Object();
        while (true) {
            synchronized (object) {
                if (tickt_number > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "===" + tickt_number--);
                }
            }
        }
    }
}

class Testmain {

    public static void main(String[] args) {
  /*      Thread3 t3 = new Thread3();
        Thread thread = new Thread(t3);
        Thread thread1 = new Thread(t3);
        Thread thread2 = new Thread(t3);
        thread.start();
        thread1.start();
        thread2.start();*/

  /*      Cus cus = new Cus();
        Thread thread = new Thread(cus);
        Thread thread2 = new Thread(cus);
        thread.start();
        thread2.start();*/


        Ticket t = new Ticket();

        Thread thread = new Thread(t);
        Thread thread2 = new Thread(t);
        thread.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.flag = false;
        thread2.start();
    }
}

/**
 * 首先要明确哪些数据是共享数据  sum= sum+n ; 每个线程都要操作这个数据，容易造成混乱，这个地方需要同步
 * <p>
 * 其实可以对有共享数据的函数进行 synchronize 修饰
 * <p>
 * <p>
 * 总结：synchronize 可以同步代码块，这样比较灵活， 还可以修饰同步函数，这样显得更简洁
 * <p>
 * <p>
 * <p>
 * <p>
 * 如果同步函数方法用static 修饰，函数用到的锁是什么呢？
 * 通过验证发现不是this ，因为静态方法中不可能有this， 静态方法是直接加载到方法区
 * <p>
 * 静态方法进内存的时候，本类方法是没有对象的，但是一定有该文件的字节码对象 也就是 .class文件
 * 类名.class 文件
 * <p>
 * 由此判断：同步方法中，使用的对象是字节码类文件对象，类名.class文件
 */
class bank {
    private int sum;
    Object object = new Object();

    public synchronized void add(int n) {

        sum = sum + n;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("输出的sum" + sum);

    }

}

class Cus implements Runnable {

    bank bank = new bank();

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            bank.add(100);
        }
    }

    public void show() {
    }
}

class Ticket implements Runnable {
    private static int tick = 100;
    boolean flag = true;

    @Override
    public void run() {
        if (flag) {
            while (true) {
                synchronized (Ticket.class) {
                    if (tick > 0) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "===>" + tick--);
                    }
                }
            }
        } else {
            while (true) {
                show();
            }
        }
    }

    /**
     * 同步锁： 当用synchronized 修饰方法的时候，此时的锁是this，也就是对象本身，
     * 当用static synchronized 修饰方法时候，此时的锁字节码文件 类名.class 文件
     */
    public static synchronized void show() {
        if (tick > 0) {
            System.out.println(Thread.currentThread().getName() + "<=======>" + tick--);
        }
    }
}

//单例模式 恶汉式
class Single {

    private static Single s = new Single();

    private Single() {
    }

    public static Single getInstance() {

        return s;
    }

}


/**
 * 懒汉式 解析 ：延时加载实例
 * <p>
 * 首先给实例声明为空 null;
 * 第二步： 私有化构造函数，这步骤必须存在，要不然就能自己进行实例化了，就不是单例模式了
 * 第三步：判断对象是否为空，若为空 则实例化对象，若不为空，就返回对象，
 * ------synchronized 是同步代码块，经过两次判断提高了单例模式的效率。
 */

class Singlee {

    //
    private static Singlee s = null;

    private Singlee() {
    }

    public static Singlee getInstance() {

        if (s == null) {
            synchronized (Singlee.class) {
                if (s == null) {

                    s = new Singlee();
                }

            }

        }

        return s;
    }

}