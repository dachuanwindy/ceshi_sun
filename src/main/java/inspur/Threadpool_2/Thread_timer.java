package inspur.Threadpool_2;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Thread_timer {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            public void run() {
                System.out.println("delay 3 seconds");
            }
        }, 3, TimeUnit.SECONDS);
    }
}


class threadpool_study {


    public void threadpool() {

        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        newCachedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("dddd");
            }
        });
    }


    public void CopyOnWriteArrayList1() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(new ArrayList());

        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();

        ConcurrentHashMap map = new ConcurrentHashMap(100);
    }
}