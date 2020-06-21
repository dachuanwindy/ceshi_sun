package leetcode.mid;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 动态规划的题目
 * @date 2020/6/16 19:53
 */
public class 最大子序列之和 {

    public static void main(String[] args) {

        int[] arr = {-2, 1, 3, 100, -1, 2, 1, -5, 4};

        int result = maxSubArray(arr);
        System.out.println(result);

    }

    /**
     * @description: 最大子序列之和, 时间复杂度是 O(n)
     * @author sunfch
     * @date 2020/6/16 19:55
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //定义动态规划的初始
        int[] dp = new int[nums.length + 1];
        //初始值判定
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //动态转移方程,这个题关键;
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        // 找到
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
