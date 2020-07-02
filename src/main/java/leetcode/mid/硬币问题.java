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

    /**
     * @description: 种类替换与前面的状态有关.
     * @author sunfch
     * @date 2020/6/30 07:37
     */
    public static int waysToChange(int n) {

        // 硬币的种类. 这个就相当于台阶
        int[] coins = {1, 5, 10, 20, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        // 外层是种类个数
        for (int i = 0; i < coins.length; i++) {
            //遍历内层金钱,能否换成更大的种类钱
            for (int j = coins[i]; j <= n; j++) {
                //当金币=1, 所有钱都是一种换法,就是1 ,当金币=5 的时候, 前面n=4 就都有一种换法,之后
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[n];
    }

}

/**
 * 第
 */
