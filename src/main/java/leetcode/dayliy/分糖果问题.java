package leetcode.dayliy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 每日一练 :
 * @date 2020/6/1 20:46
 */
public class 分糖果问题 {

    public static void main(String[] args) {

//        int[] arr = {2, 3, 5, 1, 3};
//        List<Boolean> booleans = kidsWithCandies(arr, 3);
//        System.out.println(booleans.toString());

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 2, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(4));

        HashMap<String, Object> map = new HashMap<>();
        map.put("", "");
        map.remove("");

        Hashtable<String, Object> hashtable = new Hashtable<>();
        hashtable.put("", "");
        hashtable.get("");
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap();

        concurrentHashMap.put("", "");
        concurrentHashMap.get("");

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        try {
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }


    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> result = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            max = candies[i] > max ? candies[i] : max;
        }

        for (int i = 0; i < candies.length; i++) {
            result.add(candies[i] + extraCandies >= max);
        }
        return result;
    }
}
