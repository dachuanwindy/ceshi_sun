package Test_1.cyclicbarrier;

import java.util.concurrent.*;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 同步线程实现
 * @date 2020/3/25 09:26
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new TourGuideTask());

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new TravelAction(cyclicBarrier, "保罗"));
        executorService.execute(new TravelAction(cyclicBarrier, "保罗2"));
        executorService.execute(new TravelAction(cyclicBarrier, "保罗3"));
        executorService.execute(new TravelAction(cyclicBarrier, "保罗4"));
        cyclicBarrier.reset();
        executorService.execute(new TravelAction(cyclicBarrier, "保罗5"));
        executorService.execute(new TravelAction(cyclicBarrier, "保罗6"));
        executorService.execute(new TravelAction(cyclicBarrier, "保罗7"));
        executorService.execute(new TravelAction(cyclicBarrier, "保罗8"));
        executorService.execute(new TravelAction(cyclicBarrier, "保罗9"));
        executorService.shutdown();
    }
}

class TravelAction implements Runnable {


    private CyclicBarrier cyclicBarrier;

    private String name;

    TravelAction(CyclicBarrier cyclicBarrier, String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }

    @Override
    public void run() {

        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println(name + "到达了集合点");
            cyclicBarrier.await();
            System.out.println(name + "开始旅行了。。。");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class TourGuideTask implements Runnable {

    @Override
    public void run() {
        System.out.println("签证已发，大家可以旅行了。。。");
    }
}
