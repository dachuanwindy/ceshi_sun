package inspur.Thread_study.callablestd;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 有返回值的线程
 * @date 2020/5/16 18:32
 */
public class CallableTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(5002);
                return "孙风川";
            }
        });

        Thread thread = new Thread(futureTask);
        thread.setName("我的线程");
        thread.start();
        Object o = futureTask.get();
        System.out.println(o.toString());
        thread.join();
        System.out.println("我是主线程的输出");


    }
}
