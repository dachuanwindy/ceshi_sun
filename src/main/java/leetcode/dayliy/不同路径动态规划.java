package leetcode.dayliy;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 62题
 * @date 2020/7/7 16:08
 */
public class 不同路径动态规划 {

    public static void main(String[] args) {

        int[][] arr = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};


        int method = method(3, 3);
        System.out.println(method);
    }

    /**
     * @description: 动态规划题目:
     * 没有障碍物
     * @author sunfch
     * @date 2020/7/7 16:11
     */
    public static int method(int m, int n) {

        int[][] dp = new int[m][n];

        //没有障碍物,就是所有的数据都是1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
