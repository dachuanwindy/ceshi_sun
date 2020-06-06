package leetcode.hard;

import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 单数组接雨水
 * @date 2020/6/5 08:17
 */
public class 接雨水1 {
    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int i = method1(arr);
        System.out.println(i);
    }

    public static int method1(int[] height) {
        int[] left_arr_max = new int[height.length];
        int[] right_arr_max = new int[height.length];
        int max = 0;
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            max = height[i] > max ? height[i] : max;
            left_arr_max[i] = max;
        }
        System.out.println(left_arr_max.toString());
        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            max = height[i] > max ? height[i] : max;
            right_arr_max[i] = max;
        }
        System.out.println(right_arr_max.toString());
        for (int i = 0; i < height.length; i++) {
            int min = Math.min(left_arr_max[i], right_arr_max[i]);
            ans += (min - height[i]);
        }
        return ans;
    }

    //实现方式2 使用栈
    public static int method2(int[] height) {

        Stack<Integer> stack = new Stack<>();
        return 0;
    }


    /**使用双指针*/
}
