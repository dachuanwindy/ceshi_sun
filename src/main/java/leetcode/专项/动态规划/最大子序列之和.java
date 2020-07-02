package leetcode.专项.动态规划;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 最大子序列之和, 这个比较经典 动态规划: 53
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * @date 2020/6/29 14:19
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class 最大子序列之和 {

    public static void main(String[] args) {

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = maxSubArray(arr);
        System.out.println(i);
    }

    //    [-2,1,-3,4,-1,2,1,-5,4],
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        //记录最大的序列之和,不记录是哪个子序列
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}

