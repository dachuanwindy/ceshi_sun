package leetcode.dayliy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 阿里面试, 手写限流程序
 * @date 2020/7/7 19:52
 */
public class 手写限流程序 {

    public static void main(String[] args) {
        System.out.println("阿里让手写限流程序");

    }

    static int count;

    private static List<Integer> queue = new ArrayList<>(20);

    public static void method(String key, int duration, int times) {

        long time = System.currentTimeMillis() / 1000;
        count = count +times-
        queue.set(times % 20, times);



    }
}
