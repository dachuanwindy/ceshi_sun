import java.util.*;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/7/27 14:21
 */
public class MyTest {

    public static void main(String[] args) {

//        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
//
//
//        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
//        concurrentHashMap.put("", "");
//
//        Vector<String> strings = new Vector<>();
//        strings.add("dd");
//        poolExecutor.execute(() -> {
//            System.out.println("什么时间执行线程回收");
//        });
//
//
//        System.out.println("Hello World!");
//        int[] arr_a = {1, 2, 4, 6, 8};
//        int[] arr_b = {2, 3, 4, 6, 7, 9};
//        List<Integer> method = method(arr_a, arr_b);
//        System.out.println(method.toString());

        method2();
    }

    public static List<Integer> method(int[] a, int[] b) {
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                result.add(a[i]);
                i++;
            } else if (a[i] > b[j]) {
                result.add(b[j]);
                j++;
            } else {
                result.add(a[i]);
                result.add(b[j]);
                i++;
                j++;
            }
        }
        if (i < a.length) {
            for (int a_index = i; a_index < a.length; a_index++) {
                result.add(a[a_index]);
            }
        } else {
            for (int b_index = j; b_index < b.length; b_index++) {
                result.add(b[b_index]);
            }
        }
        return result;
    }


    public static void method2() {
        int[] arr = new int[]{2, 4, 6, 0, 6, -1, 3};
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(i, arr[i]);
        }
        //

        TreeSet<Integer> integers = new TreeSet<>();
        for (int i = 0; i < integers.size(); i++) {

        }


        HashMap<Integer, Object> arrMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsValue(5 - arr[i])) {
                System.out.println("--长度-->"+map.keySet().size());
                Set<Integer> set = map.keySet();
                for (Integer integer : set) {
                    Integer integer1 = map.get(integer);
                    if ((integer1 == (5 - arr[i])) && integer1 > i) {
                        System.out.print(arr[i] + "--->" + (5 - arr[i]) + "------>");
                        System.out.println(i + "--->" + (integer1));
                    }
                }
            }
        }
    }
}
