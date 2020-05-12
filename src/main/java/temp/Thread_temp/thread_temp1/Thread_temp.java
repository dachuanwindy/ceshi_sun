package temp.Thread_temp.thread_temp1;

/**
 * @author sunfch
 * @create 2018-11-25 22:42
 * @desc 交叉输出 打印奇数 偶数
 **/
public class Thread_temp {

    public static void main(String[] args) {
        Num num = new Num();

        Jishu jishu = new Jishu(num);
        Oushu oushu = new Oushu(num);

        new Thread(jishu).start();
        new Thread(oushu).start();

    }
}

class Num {
    int i = 1;
    boolean flag = false;

}

class Jishu implements Runnable {

    Num num;

    Jishu(Num num) {
        this.num = num;
    }

    @Override
    public void run() {

        while (num.i < 100) {
            synchronized (num) {
                if (num.flag) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("---奇数" + num.i);
                    num.flag = true;
                    num.i++;

                }
            }
        }
    }
}

class Oushu implements Runnable {

    Num num;

    Oushu(Num num) {
        this.num = num;
    }

    @Override
    public void run() {

        while (num.i < 100) {
            synchronized (num) {
                if (num.flag) {
                    System.out.println("偶数" + num.i);
                    num.flag = false;
                    num.i++;

                } else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}