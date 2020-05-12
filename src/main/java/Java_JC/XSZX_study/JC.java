package Java_JC.XSZX_study;

public class JC {
    public static void main(String[] args) throws Throwable {
        BBB ba = new BBB();
        ba.m1();
        ba.m3();
    }
}
class AAA {

    public AAA() {
        System.out.println("我是父类构造器");
    }

    void m1() {
        System.out.println("我是父类方法");
    }

    final void m2() {
        System.out.println("我是用final 关键字修饰过的父类方法");
    }
}

class BBB extends AAA {
    public BBB() {
        System.out.println("我是BBB构造器");
    }

    void m1() {
        System.out.println("BBB类的方法m1");
    }

    void m3() throws Throwable {

        try {
            int a = 5 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            finalize();
        }


    }
}