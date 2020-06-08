package leetcode.hard;

import java.util.Vector;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 最少的纸币面额, 组成数据
 * <p>
 * 动态规划的核心:
 * 1.base边界
 * @date 2020/6/6 18:43
 */
public class 动态规划纸币问题 {

    public static void main(String[] args) {
        Vector<Integer> coins = new Vector<>();
        coins.add(1);
        coins.add(2);
        coins.add(5);

        int[] arr = {2};
        int method = method(arr, 3);
        System.out.println(method);

    }

    /**
     * description: 最少的数量完成
     *
     * @param coins  钱币的种类
     * @param amount 总金额
     * @return int
     */
    public static int method(int[] coins, int amount) {

        if (amount <= 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {

            for (int j = 0; j < coins.length; j++) {
                if (i < coins[j]) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
