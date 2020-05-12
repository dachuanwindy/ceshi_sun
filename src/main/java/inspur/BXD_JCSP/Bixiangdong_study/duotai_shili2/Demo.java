package inspur.BXD_JCSP.Bixiangdong_study.duotai_shili2;
// 当两个对象进行比较的时候，原生态方法是比较两个对象在虚拟机中的地址

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 要想实现比较功能，就必须重写 Object（祖师爷）的方法。equals方法
 * 第一步：
 */
public class Demo {
    int number;

    Demo(int number) {
        this.number = number;
    }

    public boolean equals(Object object) {
        Demo demo = (Demo) object;
        return this.number == demo.number;
    }
}

class Testmain {

    private static final int  a  = 491;

    public static void main(String[] args) throws FileNotFoundException {

        synchronized (new Object()) {
            System.out.println("哈哈哈");
        }

        ReentrantLock reentrantLock = new ReentrantLock();
        try {
            //reentrantLock.lock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }


        InputStream inputStream ;
        FileInputStream fileInputStream;

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(""));



        System.out.println("多态测试·····");
        Demo demo1 = new Demo(4);
        Demo demo2 = new Demo(4);

        Class c = demo1.getClass();


        Method[] a = c.getMethods();
        for (Method t : a) {
            System.out.println(t.toString());


        }
        System.out.println("比较大小。。。》》》》" + demo1.equals(demo2));

        List<String> source = new ArrayList<>();

        String target = "12345678";

        Iterator it = source.iterator();

        while (it.hasNext()) {
            if (target.contains(it.next().toString())) {

            }
        }


    }
}