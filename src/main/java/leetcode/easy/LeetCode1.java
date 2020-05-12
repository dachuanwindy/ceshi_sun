package leetcode.easy;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/3/20 08:44
 */
public class LeetCode1 {


    public static void main(String[] args) throws InterruptedException, IOException {

        Integer integer = new Integer(5);
        integer.toString();

        ArrayList list = new ArrayList();
        list.add("");

        Map map = new HashMap(2);
        map.put("", "");

        BlockingQueue blockingQueue = new LinkedBlockingDeque();
        blockingQueue.put("");
        blockingQueue.take();

        ArrayBlockingQueue<String> strings = new ArrayBlockingQueue<>(3);
        strings.add("");
        strings.put("aaaa");

        SynchronousQueue synchronousQueue = new SynchronousQueue();

        synchronousQueue.put("dddd");
        strings.peek();
        synchronized (LeetCode1.class) {

            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(""));


            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.put("aaa", "aaaa");

            Hashtable hashtable = new Hashtable();

            hashtable.put("aaa", "放到大发大发大");


            FileInputStream fileInputStream = new FileInputStream("");
            FilterInputStream dataInputStream = new DataInputStream(fileInputStream);
            dataInputStream.read(new byte[1024]);

            InputStreamReader inputStreamReader1 = new InputStreamReader(fileInputStream);
        }

    }

    //    给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
    //    换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
    //    以数组形式返回答案。

    public static void method1(int[] nums) {

        int length = nums.length;
        int[] countArr = new int[length];
        for (int i = 0; i < length; i++) {
            int count = 0;
            for (int j = 0; j < length; j++) {
                if (nums[i] < nums[j]) {
                    count++;
                }
            }
            countArr[i] = count;
        }
    }

    //  请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
    //  现有一个链表 -- head = [4,5,1,9]，它可以表示为:


}

/**
 * @author sunfch
 * @description: a泛型好处： 提高了代码的可读性，
 * 而且防止强转换，避免了一些异常的发生；
 * <p>
 * 泛型分为接口泛型， 类泛型，方法泛型 ：
 * @date 2020/3/21 16:01
 */
class A {

    public <T> String Aaaa(T x) {
        System.out.println(x);

        return "";
    }
}

class B<T> {

    String retudata(T t) {
        return t.toString();
    }
}

interface AA<T> {
    String aaa(T t);
}

class SortBinary {


    // 数组arr 要查找的值key
    int binarySort(int[] arr, int key) {

        int low = 0;

        int hight = arr.length - 1;


        while (low < hight) {
            int mid = (low + hight) / 2;

            if (arr[mid] == key) {
                return key;
            }
            if (arr[mid] > key) {
                hight = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}

/**
 * @author sunfch
 * @description: 循环打印输入ABC
 * @date 2020/3/22 08:05
 */
class ABC {

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        ABCRunnable a1 = new ABCRunnable("A", c, a);
        ABCRunnable b1 = new ABCRunnable("B", a, b);
        ABCRunnable c1 = new ABCRunnable("C", b, c);


        Thread threadA = new Thread(a1);
        Thread threadB = new Thread(b1);
        Thread threadC = new Thread(c1);

        threadA.start();
        Thread.sleep(100);
        threadB.start();
        Thread.sleep(100);

        threadC.start();
    }

}

/**
 * @author sunfc
 * <p>
 * * @description:  ABC实现类
 * @date 2020/3/22 08:07
 */
class ABCRunnable implements Runnable {

    private String chr;
    private Object pre;
    private Object now;

    ABCRunnable(String chr, Object pre, Object now) {
        this.chr = chr;
        this.pre = pre;
        this.now = now;
    }

    @Override
    public void run() {
        synchronized (pre) {
            synchronized (now) {
                //输出当前值
                System.out.println(chr);
                // now.notify();
            }
            try {
                //  pre.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
