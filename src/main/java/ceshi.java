import DTO.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ceshi {

    ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static void main(String[] args) {
        String s = String.valueOf(Math.abs(new SecureRandom().nextLong()));
        System.out.println("====" + s);
        Object o = new Object();

        ThreadLocal threadLocal =new ThreadLocal();
        threadLocal.set("");

        threadLocal.get();
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

        ArrayList<String> list = new ArrayList<>();


        list.add("sss");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ddddd");
        stringBuilder.append("ewew");
        stringBuilder.append("bac");
        StringBuilder reverse = stringBuilder.reverse();
        System.out.println(reverse);

        HashMap<Object, Object> map = new HashMap<>();
        boolean equals = map.equals("");


    }
}

class test {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        readWriteLock.writeLock();
        System.out.println("======先是写锁=====");
        readWriteLock.readLock();
        System.out.println("这样可以吗？");

        BlockingQueue blockingQueue = new ArrayBlockingQueue(10);

        LinkedBlockingDeque<Object> objects = new LinkedBlockingDeque<>();
        Socket socket = new Socket();


        Class clazz = null;
        clazz = User.class;
        Class[] ptype = new Class[]{String.class};
        Method method = clazz.getMethod("getName", ptype);

        Object invoke = method.invoke(clazz.newInstance(), "dfdfdf");
        System.out.println(invoke.toString());

    }
}