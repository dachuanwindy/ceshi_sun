package juc_study.fork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.LongStream;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 流式计算 常用的是Map  List
 * @date 2020/6/22 15:19
 */
public class 流式计算学习 {

    public static void main(String[] args) {
        System.out.println("实现stream流");
        long count = LongStream.rangeClosed(1, 100).parallel().sum();
        System.out.println(count);

        Map<String, String> map = new HashMap<>();
        ArrayList<Object> list = new ArrayList<>();

    }
}
