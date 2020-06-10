package leetcode.mid;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 完全背包问题----每一项可以重复选择
 * <p>
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/9 09:30
 */
public class 背包问题完全 {

    public static void main(String[] args) {

        int[] coins = {2, 5};

        int i = coinChange(coins, 3);
        System.out.println(i);

    }


    // 主要功能实现了,边界功能没有实现
    public static int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        dp[0] = 0;

        int min = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] < min) {
                    min = dp[i - coins[j]] + 1;
                }
                //将最小的数量给当前位置;
                dp[i] = min;
            }
        }
        return dp[amount];
    }
}
/*
 * 分析:
 * 1.纸币面额为1,2,5时候;
 * 0-->0
 * 1->1
 * 2->1   dp[i-coins[1]]=0  0+1=1
 * 3->2
 * 4->2
 * 5->1
 * 以此类推;
 *
 *
 *
 *
 *
 * */