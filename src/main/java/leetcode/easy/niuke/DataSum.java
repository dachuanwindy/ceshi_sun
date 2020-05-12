package leetcode.easy.niuke;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 一个数组 [ 2 7 10,15] target=9  两数之和等于9
 * @date 2020/3/29 15:42
 */
public class DataSum {

    public static void main(String[] args) {
        int[] arr = {2, 7, 9, 15};
        solution(arr, 9);
    }

    public static void solution(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap();

        //  将数据放入map中
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            int key = target - arr[i];
            if (map.containsKey(key) && map.get(key) != i) {
                System.out.println("输出正确结果");
                break;
            }
        }

    }
}
