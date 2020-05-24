package leetcode.easy.经典面试题;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 面试:编写一个死锁程序
 * @date 2020/5/24 00:38
 */
public class 编写一个死锁程序 {

    private static Object a = "12345";
    private static Object b = "45678";

    public static void main(String[] args) {
        System.out.println("死锁程序");

        new Thread(new A(a, b)).start();
        new Thread(new A(b, a)).start();
    }

    static class A implements Runnable {
        private Object object;
        private Object objectb;

        public A(Object a, Object b) {
            this.object = a;
            this.objectb = b;
        }

        @Override
        public void run() {
            synchronized (object) {
                System.out.println("输出对象" + object.toString());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (objectb) {
                    System.out.println("对象2的输出");
                }
            }
        }
    }
}
