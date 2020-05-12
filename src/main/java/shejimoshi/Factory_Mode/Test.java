package shejimoshi.Factory_Mode;

/* 抽象工厂的设计理念 A 接口有方法  B，C 类分别实现A 方法
 *
 *   D 接口有A类型的方法，
 *   BB ，CC 实现D类的方法，实现原理就是返回A类的方法，调用 BC，
 *
 *   思路整理： A 接口 ，有方法： B，C 实现
 *
 *   D 接口有方法 A类型的 方法，
 *    BB，CC 实现 D 接口方法，返回 B，C， 就实现了调用。
 *
 * 静态方法工厂（这个用的还是比较多的），里面定义各种静态方法 类似于util 工具类
 *
 *
 * */


interface A {
    void m1();
}

class B implements A {
    @Override
    public void m1() {
        System.out.println("B  实现了方法1");
    }
}

class C implements A {


    @Override
    public void m1() {
        System.out.println("C 实现了方法A");
    }
}


/**
 * @Description: 这个是工厂接口
 * @Author: sunfch
 * @Date: 2019/2/20-20:47
 * @Param:
 * @Return:
 */
interface D {

    A aa();
}

/**
 * @Description: 这个就好比 中国工厂的方法
 * @Author: sunfch
 * @Date: 2019/2/20-20:49
 * @Param:
 * @Return:
 */
class BB implements D {

    @Override
    public A aa() {
        return new B();
    }
}

/**
 * @Description: 这个就好像美国工厂的方法
 * @Author: sunfch
 * @Date: 2019/2/20-20:50
 * @Param:
 * @Return:
 */
class CC implements D {
    @Override
    public A aa() {
        return new C();
    }
}

public class Test {

    public static void main(String[] args) {

        D dd = new BB();
        A aa = dd.aa();
        aa.m1();


        D dd1 = new CC();
        aa = dd1.aa();
        aa.m1();

    }

}