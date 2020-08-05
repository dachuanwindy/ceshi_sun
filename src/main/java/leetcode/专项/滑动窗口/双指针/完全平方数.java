package leetcode.专项.滑动窗口.双指针;

import java.util.Arrays;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 279. 完全平方数
 * @date 2020/7/21 18:41
 * <p>
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 完全平方数 {

    public static void main(String[] args) {
        System.out.println("完全平方数");
        int i = numSquares(1);
        System.out.println(i);
    }

    /**
     * @description: 完全平方数, 这个竟然能用动态规划去做题
     * @author sunfch
     * @date 2020/7/21 21:08
     * <p>
     * 这个题转化成了最少的钱币 换零钱, 其中的零钱是基本数的平方,  总和就是钱币之和.
     */
    public static int numSquares(int n) {

        //声明动态数组;
        int dp[] = new int[n + 1];
        dp[0] = 0;
        Arrays.fill(dp, Integer.MAX_VALUE);

        int midValue = (int) Math.sqrt(n) + 1;
        int[] money = new int[midValue];
        for (int i = 1; i < midValue; i++) {
            money[i] = i * i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < midValue; j++) {
                if (i < money[j]) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - money[j]] + 1);
            }
        }
        return dp[n];

    }
}

