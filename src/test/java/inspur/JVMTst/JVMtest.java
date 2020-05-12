package inspur.JVMTst;

import org.apache.activemq.util.Suspendable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class JVMtest {

    public static void main(String[] args) {
        System.out.println("正常输出，接下来测试JVM");
        List<Object> list = new ArrayList<>();
        int count = 0;
        while (true) {
            System.out.println("能正常输出" + count++);

            synchronized (new Object()) {

            }
        }
    }


}


/**
 * @Description: hashmap 扩容问题
 * @Author: sunfch
 * @Date: 2019/2/16-14:11
 * @Param:
 * @Return:
 */
class InfiniteLoop {

    static final Map<Integer, Integer> map = new HashMap<Integer, Integer>(2, 0.75f);

    public static void main(String[] args) throws InterruptedException {

        map.put(5, 55);

        new Thread("Thread1") {
            public void run() {
                map.put(7, 77);
                System.out.println(map);
            }

            ;
        }.start();

        new Thread("Thread2") {
            public void run() {
                map.put(3, 33);
                System.out.println(map);
            }

            ;
        }.start();

    }

}


/**
 * @Description: 构造函数，静态代码块加载顺序
 * <p>
 * 子类继承了父类，当子类实例化的时候，会调用父类构造函数 ，当父类没有显式构造函数时，就调用隐式构造函数；
 * @Author: sunfch
 * @Date: 2019/2/16-16:21
 * @Param:
 * @Return:
 */
class constructtest extends B {

    static {
        System.out.println("子类的静态代码块");
    }

    public static void main(String[] args) {

        constructtest constructtest = new constructtest();
    }
}

class B {
    static {
        System.out.println("静态代码块B==");
    }


    B() {
        System.out.println("构造函数B");
    }
}


/**
 * @Description: threadlocal 变量测试
 * <p>
 * 空间换时间的思想： 在
 * @Author: sunfch
 * @Date: 2019/2/16-16:24
 * @Param:
 * @Return:
 */
class Threadlocaltest {


    public static void main(String[] args) throws Exception {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("sunfengchuan");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1" + Thread.currentThread().getName() + "====>" + threadLocal.get());
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("dongxiaoming");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("current-thread" + Thread.currentThread().getName() + threadLocal.get());
            }
        }).start();


    }
}

/**
 * @Description: Runtime测试
 * @Author: sunfch
 * @Date: 2019/2/16-17:32
 * @Param:
 * @Return:
 */

class RuntimeTest {

    public static void main(String[] args) {
        String str = "abcderfdfdfdf";

        byte[] strBytes = str.getBytes();

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < strBytes.length; i++) {

            if (map.containsKey(strBytes[i])) {
                map.put((char) strBytes[i], map.get(strBytes[i]) + 1);
            } else {
                map.put((char) strBytes[i], 1);
            }
        }

        System.out.println(map.toString());

    }

}


/**
 * @Description: 哈希map 功能测试
 * list 功能测试，iterator
 * @Author: sunfch
 * @Date: 2019/2/17-14:53
 * @Param:
 * @Return:
 */
class concurrentHashmapTest {
    public static void main(String[] args) {

        Map<String, String> param = new HashMap<>();
        param.put("1", "11");
        param.put("2", "22");
        param.put("3", "33");
        Set<String> keys = param.keySet();

        Iterator iterable = keys.iterator();

        while (iterable.hasNext()) {
            System.out.println(param.get(iterable.next()));
        }


        List list = new LinkedList();
        list.add("aaa");
        list.add("bbb");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String string = (String) iterator.next();
            System.out.println(string);
        }
    }
}


/**
 * @Description: Finally 测试，若finally中有 返回值，并覆盖之前发返回值；
 * @Author: sunfch
 * @Date: 2019/2/17-17:54
 * @Param:
 * @Return:
 */
class FinallyTest {
    public static void main(String[] args) {
        System.out.println(methodtest());
    }

    public static String methodtest() {
        try {
            return "1";
        } finally {
            System.out.println("2===2222");
//            return "2";
        }

    }
}

/**
 * @Description: IO 设计中用到的设计模式:装饰模式  是怎么用到的，能具体讲讲吗？
 * @Author: sunfch
 * @Date: 2019/2/17-18:05
 * @Param:
 * @Return:
 */

class InpustreamStudy {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\1.txt");
        byte[] bytes = new byte[1024];
        int read = fileInputStream.read(bytes);
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\123.txt");
        while (read != -1) {
            fileOutputStream.write(bytes);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}

/**
 * @Description: hashmap  hashset 源码测试
 * @Author: sunfch
 * @Date: 2019/2/18-13:52
 * @Param:
 * @Return:
 */

class HashSet_study {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        TreeMap map = new TreeMap();
        List list = new LinkedList();

        ((LinkedList) list).addFirst("aa");

        ((LinkedList) list).removeFirst();

        Collections.sort(list, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                int i = o2.compareTo(o1);
                return i;
            }
        });


        AtomicInteger atomicInteger = new AtomicInteger();


        Vector<String> vector = new Vector<>(10);


    }
}

/**
 * @Description: 编写一个互锁的程序 -------- 这个代码有可能
 * @Author: sunfch
 * @Date: 2019/2/18-20:18
 * @Param:
 * @Return:
 */

class LockDemo {
    public static void main(String[] args) {

    }
}

class AA implements Runnable {

    static final Object aaa = new Object();
    static final Object bbb = new Object();

    private boolean flag;

    AA(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {

        if (flag) {
            synchronized (aaa) {
                try {
                    Thread.sleep(55);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (bbb) {
                    System.out.println("bbb");
                }
            }
        } else {
            synchronized (bbb) {
                synchronized (aaa) {
                    System.out.println("aaa");
                }
            }
        }

    }
}


/**
 * @Description: Lock  源码解读及测试
 * @Author: sunfch
 * @Date: 2019/2/18-23:58
 * @Param: invocation
 * @Return:
 */

class ReentrantLocktest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        lock.lock();
        lock.isFair();

        lock.unlock();
    }
}

/**
 * @Description: 单例模式
 * @Author: sunfch
 * @Date: 2019/2/19-15:22
 * @Param:
 * @Return:
 */
class outerclass {


    static class innerclass {
        static final void ceshi() {
            System.out.println("内部类实现方法");
        }
    }
}

class Test2 {
    public static void main(String[] args) {
        outerclass outerclass = new outerclass();
    }
}


/**
 * @Description: 死锁程序编写
 * @Author: sunfch
 * @Date: 2019/2/28-15:59
 * @Param:
 * @Return:
 */

class test2 {
    public static void main(String[] args) throws InterruptedException {
//        new Thread(new a(true)).start();
//        new Thread(new a(false)).start();
        WeakReference<Object> objectWeakReference = new WeakReference<Object>(new Object());
        System.out.println( objectWeakReference.get());
                ;
        System.gc();

        System.out.println(objectWeakReference.get());


        CountDownLatch countDownLatch =new CountDownLatch(12);

        countDownLatch.await();

        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("ddd");
    }
}


class a implements Runnable {

    public static Object aa = new Object();
    public static Object bb = new Object();

    private boolean flag;

    a(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {


        if (flag) {
            synchronized (aa) {
                try {
                    Thread.sleep(555);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (bb) {
                    System.out.println("aaaa");
                }
            }
        } else {
            synchronized (bb) {
                synchronized (aa) {
                    System.out.println("bbb");
                }
            }

        }
    }
}




