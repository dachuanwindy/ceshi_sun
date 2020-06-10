package leetcode.mid;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 * <p>
 * 示例1:
 * <p>
 * 输入: n = 5
 * 输出：2
 * 解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * 示例2:
 * <p>
 * 输入: n = 10
 * 输出：4
 * 解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/9 09:19
 */
public class 硬币问题 {
    public static void main(String[] args) {

        int i = waysToChange(10);
        System.out.println(i);
    }

    public static int waysToChange(int n) {

        // 4 中情况
        int[] coins = {1, 5,10, 20, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= n; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[n];
    }

}

/**
 * 第
 *
 *
 *
 */
