package Executor_stdy.Executor_styd;

/**
 * @author sunfch
 * @create 2018-03-28 14:51
 * @desc 固定线程池学习
 **/


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * executor是接口  executorservice 是子接口，比父接口用的更广泛，
 * <p>
 * 其中有两个重要的实现类 threadpoolexecutor  与 schedulderthreadpoolservice 是两个重要的实现类
 * <p>
 * 其中 threadpool 是
 * <p>
 * 能创建4种线程池： newcachedThreadpool【缓存线程池】    newfiexdThreadpool固定线程池   newschedulderThreadpool定时任务池  newsingleThreadpool
 */
public class excutor_study {


    static ExecutorService executorService = null;

    public static void main(String args[]) {

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("多线程输出。。");
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("多线程输出22");
            }
        });


        excutor_study excutor_study = new excutor_study();
        excutor_study.cachedThreadpool();
        excutor_study.singgleThreadpool();
        executorService.shutdown();


        new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < 10000000; i++) {
                    stringBuilder.append(1);
                }
                System.out.println("" + Thread.currentThread().getName());
            }
        }).start();

    }


    // 创建固定的线程池，其中注意的事项有:
    public void FixedThreadpool() {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("固定线程池");
                output111();
            }
        });
    }

    /**
     * 创建无线的线程池，这样的好处是,线程池的数量无线增加，当可以复用第一个线程，
     * <p>
     * 当线程超过设定的时间，系统会自动回收线程。
     * <p>
     * 当小于核心池的corePoolsize 的时候，可以创建线程，当大于核心线程数的时候，只能进入有序队列中等待。
     **/

    public void cachedThreadpool() {

        final StringBuilder stringBuilder = new StringBuilder();


        stringBuilder.append("真的成功了");

        executorService = Executors.newCachedThreadPool();

        executorService.execute(new Runnable() {
            @Override
            public void run() {

                shujjiami(stringBuilder.toString());
            }
        });

    }

    /**
     * 单个线程确保任务在队列中是顺序执行的，当前线程抛出异常的时候，就会创建新的线程来执行，[顺序执行]
     * <p>
     * *
     */
    public void singgleThreadpool() {
        System.out.println("创建一个线程，保证任务是顺序执行的");


        executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("创建单个线程池");
                output111();
            }
        });

    }


    /**
     * 公共业务逻辑
     */
    public static void output111() {

        for (int i = 0; i < 100; i++) {
            System.out.println("这个是我的业务逻辑==" + Thread.currentThread().getName());
        }
    }


    public String shujjiami(String sjjm) {

        if (sjjm != null) {

            System.out.println(sjjm);
        }

        return "数据加密成功";

    }


    //创建带有返回值的线程任务

    public void ceshi() {


        System.out.println("~~~~~~~~~");

        executorService = Executors.newCachedThreadPool();

        executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "我正在学多线程编程";
            }
        });


    }


}

/**
 * @Description: 设计模式--专用
 * @Author: sunfch
 * @Date: 2019/2/19-14:31
 * @Param:
 * @Return:
 */


//饿汉
class A {
    private A() {
    }

    public static final A a = new A();

    public A getinstance() {
        return a;
    }
}

//懒汉模式。改造之后线程安全
class AA {
    private AA() {
    }

    public static AA aa = null;

    public synchronized static AA getinstance() {
        if (aa == null) {
            synchronized (AA.class) {
                aa = new AA();
            }
        }
        return aa;
    }

}

/**
 * @Description: 通过内部类实现加载，这样能保证线程安全，而且不浪费资源
 * @Author: sunfch
 * @Date: 2019/2/19-14:38
 * @Param:
 * @Return: 关键点：内部类是什么时候加载并初始化的？
 */

class SafeSingleinstance {
    private SafeSingleinstance() {
    }


    public static SafeSingleinstance getInstance() {
        return singleinstanceholder.instance;
    }

    private static class singleinstanceholder {
        public final static SafeSingleinstance instance = new SafeSingleinstance();
    }

}

class singleinstanceTest {
    public static void main(String[] args) {
        SafeSingleinstance.getInstance();
        for (int i = 0; i < 100; i++) {
            System.out.println(SafeSingleinstance.getInstance());
        }

    }
}


/**
 * @Description:通过内部类的形式加载 ： 单例模式线程安全
 * @Author: sunfch
 * @Date: 2019/2/21-9:06
 * @Param:
 * @Return:
 */
class singleton {
    private singleton() {

    }

    public singleton getsingleton() {
        return singletonhoudler.getholdersinglton();
    }

    public static class singletonhoudler {

        public final static singleton getholdersinglton() {
            return new singleton();
        }
    }
}


/**
 * @Description: 饿汉模式 ： 优点是线程安全，缺点是： 启动时候加载，启动抢占资源，造成资源的浪费
 * @Author: sunfch
 * @Date: 2019/2/21-9:07
 * @Param:
 * @Return:
 */

class singleton_e {

    private singleton_e() {
    }

    public static singleton_e singleton_e = new singleton_e();

    public singleton_e getinstance() {
        return singleton_e;
    }

}

/**
 * @Description: 懒汉模式，实现了
 * @Author: sunfch
 * @Date: 2019/2/21-9:14
 * @Param:
 * @Return:
 */

class singleton_l {
    private singleton_l() {
    }

    public static volatile singleton_l instance;

    public static singleton_l getInstance() {
        if (instance == null) {
            synchronized (singleton_l.class) {
                if (instance == null) {
                    instance = new singleton_l();
                }
            }
        }
        return instance;
    }
}


class singlMain {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(singleton_l.getInstance());
                }
            }).start();
        }
    }
}
/**
 * @Description: 线程池丢弃策略
 * @Author: sunfch
 * @Date: 2019/2/21-9:22
 * @Param:
 * @Return:
 */
