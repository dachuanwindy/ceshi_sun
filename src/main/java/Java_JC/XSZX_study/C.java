package Java_JC.XSZX_study;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class A {
    public void a1() {
        System.out.println(" 我是父类");
    }
}


class B extends A {

    @Override
    public void a1() {
        System.out.println("我是子类");
    }

    public void B1() {
        System.out.println("我是B类的一个方法");

    }
}

public class C {

    public static void main(String[] args) {
        //    A A1 = new B();// 父类对象引用子类对象，这就是向上转型，但是在子类实现父类的方法是可以引用的，例a1 但是B1就不能引用
        //   A1.a1(); // 可以引用
        //   A1.B1();//不可以引用 ，就是向上转型失败


        List ls = new ArrayList();
        ls.add("dfdfd");
        ls.add(1);

        Object o = ls.get(1);
        Object object = ls.get(0);

        List ll =new ArrayList();
        Iterator iterator =ll.listIterator();


    }


}


