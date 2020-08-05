package leetcode;

import com.alibaba.fastjson.JSON;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author sunfch
 * @version V1.0
 * @Description:
 * @date 2020/6/9 07:22
 */
public class 算法总结 {


    static PriorityQueue<Integer> queue = new PriorityQueue<>(10);

    public static void main(String[] args) {
        queue.add(10);
        queue.add(11);
        queue.add(3);
        queue.add(5);
        queue.add(9);
        Object[] objects = queue.toArray();
        System.out.println(objects.toString());
        queue.remove(10);
        System.out.println(objects.toString());

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
        //ExecutorService executorService = Executors.newFixedThreadPool(3); // 创建线程池
        //   CompletionService completionService = new ExecutorCompletionService(executorService);

        //    completionService.submit()

        long l = System.currentTimeMillis();

        String a = "[{\"茶叶\":\"菊花茶\",\"茶叶\":\"正山小种\"},{\"裤子分类\":\"蓝色裤子\",\"适用床尺寸\":\"1.8m（6英尺）床\",\"颜色分类\":\"海棠红+赠品\"},{\"适用床尺寸\":\"1.5m（5英尺）床\",\"颜色分类\":\"湛蓝\"},{\"适用床尺寸\":\"1.8m（6英尺）床\",\"颜色分类\":\"烟灰+赠品\"},{\"适用床尺寸\":\"1.5m（5英尺）床\",\"颜色分类\":\"湛蓝+赠品\"},{\"适用床尺寸\":\"1.5m（5英尺）床\",\"颜色分类\":\"海棠红\"},{\"适用床尺寸\":\"1.8m（6英尺）床\",\"颜色分类\":\"湛蓝+赠品\"},{\"适用床尺寸\":\"1.5m（5英尺）床\",\"颜色分类\":\"海棠红+赠品\"},{\"适用床尺寸\":\"1.5m（5英尺）床\",\"颜色分类\":\"烟灰\"},{\"适用床尺寸\":\"1.8m（6英尺）床\",\"颜色分类\":\"烟灰\"},{\"适用床尺寸\":\"1.8m（6英尺）床\",\"颜色分类\":\"湛蓝\"},{\"适用床尺寸\":\"1.8m（6英尺）床\",\"颜色分类\":\"海棠红\"},{\"适用床尺寸\":\"1.5m（5英尺）床\",\"颜色分类\":\"烟灰+赠品\"}]";

        Map[] collect3 = JSON.parseArray(a).stream().collect(Collector.of(() ->
                        new Map[]{new LinkedHashMap<String, Map<String, Integer>>(), new LinkedHashMap<String, String>(), new LinkedHashMap<String, List<String>>()},
                (c, p) -> c[1].put(p, ((Map<String, String>) p).entrySet().stream().map(x -> {
                    ((LinkedHashMap<Object, Map<String, Integer>>) c[0]).compute(x.getKey(), (k, v) -> v == null ? new LinkedHashMap<String, Integer>() {{
                        put(x.getValue(), 1);
                    }} : (v.computeIfAbsent(x.getValue(), (v2) -> v.size() + 1) > 0 ? v : null));
                    return String.valueOf(((LinkedHashMap<Object, Map<String, Integer>>) c[0]).get(x.getKey()).get(x.getValue()));
                }).reduce((x, y) -> x + "@" + y).get()), (c1, c2) -> c1, t -> {
                    t[2] = ((LinkedHashMap<String, Map<String, Integer>>) t[0]).entrySet().stream().collect(Collectors.toMap(k -> k.getKey() + "@" + k.getValue().size(), s -> s.getValue().entrySet().stream().map(x -> x.getKey() + "@" + x.getValue()).collect(Collectors.toList()), (v1, v2) -> v1, LinkedHashMap::new));
                    return t;
                }));

        Map<Object, String> map = collect3[1];
        System.out.println("map");
        map.forEach((x, y) -> System.out.println(x + "==" + y));
        System.out.println("预留");
        Map<String, List<String>> reserved = collect3[2];
        System.out.println(JSON.toJSONString(reserved));
        long e = System.currentTimeMillis();
        System.out.println(e - l);
    }
}
/**
 * 数据结构: 链表, 数组
 * <p>
 * <p>
 * <p>
 * stack  queue, hashMap  List, 数组[][],
 */

