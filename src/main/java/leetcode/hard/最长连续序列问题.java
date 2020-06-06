package leetcode.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 要求 时间复杂度为 n;
 * 注意: 由 n2 或者 nlogM 这样的问题,转成 n 肯定需要借助外部资源;
 * 空间换时间; 或者特性换时间
 * <p>
 * 这问题就是利用hash特性换时间;
 * <p>
 * <p>
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * @date 2020/6/6 18:47
 */
public class 最长连续序列问题 {
    public static void main(String[] args) {
        System.out.println("数组中最长的连续子串");

        int[] arr = new int[]{0, 0, 1, 2, 3, 5};
        int method = method(arr);
        System.out.println(method);
    }

    public static int method(int[] nums) {

        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            sets.add(nums[i]);
        }
        int maxCountValue = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int data = nums[i];
            count = 1;
            while (sets.contains(data)) {
                data = data + 1;
                if (sets.contains(data)) {
                    count++;
                }
            }
            maxCountValue = Math.max(count, maxCountValue);
        }
        return Math.max(count, maxCountValue);
    }
}
