package leetcode.dayliy;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 大顶堆 ,小顶堆问题
 * <p>
 * 默认是构建小顶堆, 在使用 Collections.reverseOrder() 之后是构建的大顶堆;
 * @date 2020/6/3 11:47
 */
public class 大顶堆问题 {
    public static void main(String[] args) {

        maxHeap.add(1);
        maxHeap.add(2);
        maxHeap.add(5);
        maxHeap.add(4);
        maxHeap.offer(4);

        //peek 窥探,只是看到第一个数据
        Integer peek = maxHeap.peek();
        System.out.println(maxHeap.peek());
        // poll是轮询, 轮询就要取下一个数据,前一个数据就要取出来,
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.peek());

        minHeap.add(33);
        minHeap.add(34);
        minHeap.add(36);
        minHeap.add(22);
        minHeap.add(200);
        System.out.println(minHeap.peek());
        System.out.println(minHeap.add(15));
        System.out.println(minHeap.peek());
    }

    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(DEFAULT_INITIAL_CAPACITY, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });


    //
    static PriorityQueue minHeap = new PriorityQueue(Collections.reverseOrder());


}
