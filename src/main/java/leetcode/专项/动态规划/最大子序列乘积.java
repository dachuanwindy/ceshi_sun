package leetcode.专项.动态规划;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 乘积最大子数组, 动态规划问题
 * @date 2020/6/16 18:31
 */
public class 最大子序列乘积 {

    public static void main(String[] args) {
        int[] ints = {1, 2, -3, 4, 5};
        int i = maxProduct(ints);
        System.out.println(i);
    }

    /**
     * @description: 乘积最大子数组;
     * @author sunfch
     * <p>
     * 定义动态初始值---这个是个技术活,分析清楚了,后面就
     * 好做了
     * <p>
     * 状态转移方程
     * @date 2020/6/16 18:32
     */
    public static int maxProduct(int[] nums) {

        //状态设计,这个很重要; 其中 第二个0是最小值, 1是最大值
        // dp[i][0] 是指以 num[i] 结尾的连续子数组的最大值
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][0]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][1]);
            } else {
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][1]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][0]);
            }
        }
        // 判断这个对象是
        int result = dp[0][1];
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, dp[i][1]);
        }
        return result;
    }

}
