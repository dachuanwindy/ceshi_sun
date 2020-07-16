package leetcode.dayliy;

import java.util.Arrays;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 334. 递增的三元子序列
 * @date 2020/7/16 08:57
 */
public class 递增三元子序列 {

    public static void main(String[] args) {

        int[] arr = {1,1,1,1,1};
        boolean contains = isContains(arr);
        System.out.println(contains);

        boolean contains2 = isContains2(arr);
        System.out.println(contains2);

    }


    /**
     * @description: 这个三元还行得通, 四元或者多元就不可以这么做了
     * @author sunfch
     * @date 2020/7/16 09:05
     */
    public static boolean isContains(int[] arr) {

        int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= m1) {
                m1 = arr[0];
            } else if (arr[i] <= m2) {
                m2 = arr[i];
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * @description: 通用做法采用 动态规划
     * @author sunfch
     * @date 2020/7/16 09:08
     */
    public static boolean isContains2(int[] arr) {

        int[] dp = new int[arr.length];

        Arrays.fill(dp, 1);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] >= 3) {
                return true;
            }
        }
        return false;
    }

}

