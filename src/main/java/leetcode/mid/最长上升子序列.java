package leetcode.mid;

import java.util.Arrays;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 动态规划题目
 * @date 2020/6/16 20:36
 */
public class 最长上升子序列 {
    public static void main(String[] args) {
        int[] ints = {1,3,6,7,9,4,10,5,6};
        int i = lengthOfLIS(ints);
        System.out.println("输出结果是===" + i);
    }

    /**
     * @description: 采用动态规划;
     * <p>
     * <p>
     * 我自己的思考:
     * 整个数组中比当前值大的个数
     * @author sunfch
     * @date 2020/6/16 20:36
     */
    public static int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        //定义动态规划的数组 并初始化;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    //状态转移方程, 最大的的递增长度
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxVal = 0;
        for (int i = 0; i < dp.length; i++) {
            maxVal = Math.max(maxVal, dp[i]);
        }
        return maxVal;

    }

}
