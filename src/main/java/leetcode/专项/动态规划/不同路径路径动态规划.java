package leetcode.专项.动态规划;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 62题
 * 题目是:为什么要用动态规划: 我这一步与上一步有关系, 要记录上一步的内容才能推测下一步
 * @date 2020/7/8 16:08
 */
public class 不同路径路径动态规划 {


    public static void main(String[] args) {
        System.out.println("从起点到终点有多少种走法==  没有障碍");
        int method = method(3, 3);
        System.out.println(method);
    }

    /**
     * @description: 没有障碍
     * 1 1 1
     * 1 1 1
     * 1 1 1
     * @author sunfch
     * @date 2020/7/8 16:18
     */
    public static int method(int a, int b) {

        int[][] dp = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[a - 1][b - 1];
    }

    /**
     * @description: 中间有个障碍, 解决思路:
     * @author sunfch 动态规划,只要下一步,有上一步,有关系,就需要记录,动态规划就是一种解决方案
     * <p>
     * 0 0 0
     * 0 1 0
     * 0 0 0
     * @date 2020/7/8 16:20
     */
    public static int method(int[][] arr) {

        int[][] ints = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
        }

        return 0;
    }
}
