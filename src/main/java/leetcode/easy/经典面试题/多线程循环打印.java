package leetcode.easy.经典面试题;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 多线程循环打印
 * @date 2020/5/23 11:54
 */
public class 多线程循环打印 {

    static Object a = new Object();
    static Object b = new Object();
    static Object c = new Object();

    public static void main(String[] args) {
        System.out.println("哈哈哈哈");
        for (int i = 0; i < 2; i++) {
            new Thread(new A(a, "A", b), "线程1").start();
            new Thread(new A(b, "B", c), "线程2").start();
            new Thread(new A(c, "C", a), "线程3").start();
        }

        int i = Thread.activeCount();
        System.out.println(i);
    }

    static class A implements Runnable {
        private Object object;
        private Object next;

        private String str;

        public A(Object o, String str, Object next) {
            this.object = o;
            this.str = str;
            this.next = next;
        }

        @Override
        public void run() {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + ":" + str);
                try {
                    object.wait();
                    next.notify();
                } catch (InterruptedException e) {
                }
            }
        }


    }

}
