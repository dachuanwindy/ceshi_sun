package inspur.Thread_study;

import org.apache.commons.collections.map.HashedMap;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main1(String[] args) {
        Map map =new HashMap(12);
        map.size();

        multiThread m1 = new multiThread("A");
        multiThread m2 = new multiThread("B");
        System.out.println("@@@@@@" + Thread.currentThread().getName());
        m1.start();
        m2.start();
        Socket.class.getClass();

        System.out.println("实现Runable方法");
        Runable_method rm = new Runable_method();
        Thread thread = new Thread(rm);
        thread.start();

    }
}


class B {

    B b;

    public B() {
    }

    public B(Object o) {
        System.out.println("Object");
    }

    public B(String str) {

        System.out.println("string leixing ");
    }


    public static void main(String[] agrs) {

        B b = new B(new Object());

        char[] a = new char[1000];

        a[0] = 'a';

        String aa = null;

        System.out.println("String 默认值" + aa);


        Boolean boo = null;

        System.out.println("Boolean 默认值" + boo);


        byte[] aqq = new String("qqqqqqqqqqq").getBytes();

        Map<String, Integer> map_2 = new HashedMap();

        int length = aqq.length;

//        A bb = new BB();
//        bb.Gettime();


        A2 a2 = new A2();
        a2.method_1();
        a2.method_2();
    }

}


abstract class A {

    public final void Gettime() {

        long starttime = System.currentTimeMillis();


        method_1();
        long endtime = System.currentTimeMillis();

        long time = endtime - starttime;

        System.out.println("程序消耗的时间是" + time);

    }


    abstract void method_1();


}

class BB extends A {


    @Override
    void method_1() {

        for (int i = 0; i < 200; i++) {
            System.out.println("0");
        }

    }
}


class A1 {

    void method_1() {

        System.out.println("方法1");
    }

    void method_2() {

        System.out.println("方法2");
    }
}

class A2 extends A1 {

    void method_1() {

        System.out.println(" 这个是子类重写的方法");

        int a;

        Integer a11= new Integer("123232");

    }

}