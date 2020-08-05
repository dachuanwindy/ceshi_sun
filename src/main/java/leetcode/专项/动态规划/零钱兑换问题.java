package leetcode.专项.动态规划;

import java.util.Arrays;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 322. 零钱兑换
 * @date 2020/7/25 14:26
 */
public class 零钱兑换问题 {

    public static void main(String[] args) {

        int[] coins = { 2,5};
        int method = method(coins, 3);
        System.out.println(method);
    }

    /**
     * @description: 零钱兑换问题,
     * 技术分析: 我当前的兑换数量与之前的有关系;,所以要记录,所以要
     * @author sunfch
     * @date 2020/7/25 14:27
     */
    public static int method(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount]==amount?-1:dp[amount];

    }
}
