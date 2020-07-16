package leetcode.dayliy;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 309
 * @date 2020/7/10 08:26
 */
public class 买卖股票最佳时机有冷冻期 {

    public static void main(String[] args) {
        System.out.println("买卖股票最大收益,还有冷冻期");

        int[] arr = {1, 2, 3, 0, 2};
        int i = maxProfit(arr);
        System.out.println(i);
    }

    public static int maxProfit(int[] arr) {

        int[][] dp = new int[arr.length][3];
        /**
         *
         * dp[i][0] 手上持股的最大收益;
         * dp[i][1] 手上不持股的在冷冻期的最大收益;
         * dp[i][2]  手上不持股的最大收益-----不在冷冻期;
         *
         *
         * */

        dp[0][0] = -arr[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < arr.length; i++) {
            // 手上持股
            dp[i][0] = Math.max(dp[i - 1][0], dp[i-1][2] - arr[i]);
            // 手上不持股,在冷冻期=====就是把昨天的股票买掉挣得钱;
            dp[i][1] = dp[i - 1][0] + arr[i];
            // 手上不持股,但不冷冻=====昨天的冷冻 + 昨天的不冷冻
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        return Math.max(dp[arr.length - 1][1], dp[arr.length-1][2]);
    }
}
