package YWSJ.GNSJ;

import java.util.concurrent.*;

/**
 * @author sunfch
 * @create 2018-03-25 11:26
 * @desc 业务逻辑层
 **/
public class Ywlj {


    private StoreSys add_digdan(StoreSys storeSys) {

        storeSys.setGoodsName("sunfengchuan");
        storeSys.setGoodsPrice(12);
        return storeSys;


    }

    public static void main(String[] args) {

        Ywlj ywlj = new Ywlj();

    }
}

class AA {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("这个是线城池的学习测试");


  /*      ExecutorService laodaA = Executors.newFixedThreadPool(7);

        String aafdfd = laodaA.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                return "我已经完成任务了";
            }

        }).get();


        System.out.println(aafdfd);*/


        ExecutorService es = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {

            System.out.println("   " + i + "    " + Thread.currentThread().getName());
        }
/*        es.execute(new Runnable() {
            @Override
            public void run() {
                //这个地方是我要执行的业务逻辑
                //这个业务逻辑new thread 中的业务逻辑是一样的

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 500; i++)
                    System.out.println("我要执行的业务逻辑是...." + i + "     " + Thread.currentThread().getName());
            }
        });*/


/*        es.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {

                    System.out.println("======>>>" + i + "    " + Thread.currentThread().getName());
                }
            }
        });*/

        System.out.println("完事了····");
        ScheduledExecutorService es1 = Executors.newScheduledThreadPool(7);
        es1.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {

                System.out.println("每个5秒钟执行一次");

            }
        }, 5, 5, TimeUnit.SECONDS);
    }


}


class callable implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "callable 我要去。。。。";
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("进军。。。。。");

        Callable<String> callable = new callable();

        FutureTask<String> future = new FutureTask(callable);

        new Thread(future).start();

        String dd = future.get();

        System.out.println("...>>>.....>>>>" + dd);
    }
}

class  fffff extends  Thread{


    public  void  run(){



    }
}