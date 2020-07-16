package leetcode.dayliy;

import inspur.Thread_study.Threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 315
 * <p>
 * <p>
 * 315. 计算右侧小于当前元素的个数
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 * @date 2020/7/11 15:39
 */
public class 计算右侧小于当前元素的个数 {

    public static void main(String[] args) {
        System.out.println("==========");
        int[] arr = {6, 5, 4, 3, 2, 1};

        List<Integer> method = method(arr);
        System.out.println(method.toString());
    }


    /**
     * @description: 暴力解决方案
     * @author sunfch
     * @date 2020/7/11 16:32
     */
    public static List<Integer> method(int[] arr) {

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
            result.add(count);
        }

        return result;
    }

}


class MyTest{
    public static void method() throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<String> result = executorService.submit(new myCallable());
        String s = result.get(5,TimeUnit.MILLISECONDS);
        System.out.println(s);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,
                5,
                5,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5), new ThreadPoolExecutor.CallerRunsPolicy());


        threadPoolExecutor.setCorePoolSize(5);


    }

    static class myCallable implements Callable<String> {


        @Override
        public String call() throws Exception {

            System.out.println("这个是我的第一个进程");

            Thread.sleep(555);
            return "hhhh";
        }
    }

    static  class  MyRunnable implements  Runnable{
        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {

        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        method();


    }
}
