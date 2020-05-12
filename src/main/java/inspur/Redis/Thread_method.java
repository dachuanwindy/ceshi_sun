package inspur.Redis;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Thread_method extends Thread {

    int i = 0;

    public Thread_method(int i) {
        this.i = i;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            Thread_method t = new Thread_method(i);
            t.start();
        }
    }

    public void run() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        //   Redis_pool.setString("foo", time);
        //   String foo = Redis_pool.getString("foo");
        System.out.println("【输出>>>>】foo:" + "foo" + " 第：" + i + "个线程" + "当前时间：" );
    }
}