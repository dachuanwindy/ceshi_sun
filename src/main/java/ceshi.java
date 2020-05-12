import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ceshi {

    ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static void main(String[] args) {


//       ExecutorService service= Executors.newWorkStealingPool(20);

        String s = String.valueOf(Math.abs(new SecureRandom().nextLong()));
        System.out.println("====" + s);

    }


}


/**
 * @Description: //TODO 单例模式 ，懒汉模式，实现了线程安全，判断是否为空，
 * @Author: sunfch
 * @Date: 2019/1/6 16:53
 * @Param:
 * @Return:
 */
class B {

    public static volatile B instance = null;

    private B() {
    }


    // 双重检测机制，实现线程安全，第一次检测，判断实例是否为空，第二次加锁判断若不为空，则创建对象，这样的好处是
    public static B getInstance() {
        if (instance == null) {
            synchronized (B.class) {
                if (instance == null) {
                    instance = new B();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) {
        String[] cmd = {"/bin/sh", "-c", "ll "};
        InputStream in = null;
        String result = null;
        try {
            Process pro = Runtime.getRuntime().exec(cmd);
            pro.waitFor();
            in = pro.getInputStream();

            BufferedReader read = new BufferedReader(new InputStreamReader(in));
            while ((result = read.readLine()) != null) {
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class test {

    public static void main(String[] args) {

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        readWriteLock.writeLock();
        System.out.println("======先是写锁=====");
        readWriteLock.readLock();
        System.out.println("这样可以吗？");

        BlockingQueue blockingQueue = new ArrayBlockingQueue(10);

        LinkedBlockingDeque<Object> objects = new LinkedBlockingDeque<>();


    }
}