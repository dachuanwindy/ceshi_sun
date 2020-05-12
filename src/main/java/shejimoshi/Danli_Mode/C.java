package shejimoshi.Danli_Mode;

/*对于单例模式的几种实现方式，知道饿汉式和懒汉式的区别，线程安全，资源加载的时机，
 *还有懒汉式为了实现线程安全的3种方式的细微差别。
 * http://blog.csdn.net/jason0539/article/details/23297037/
 * */
class A {

    private A() {
    }

    public static final A a = new A();

    public static A getinstance() {
        System.out.println("单例模式");
        return new A();
    }
}

public class C {

    public static void main(String[] args) {

    }
}
