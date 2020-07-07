package leetcode.dayliy;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 不同路径, 但是中间有障碍物
 * @date 2020/7/7 16:52
 */
public class 不同路径有障碍物 {

    public static void main(String[] args) {


        int arr[][] = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int method = method(arr);
        System.out.println(method);

    }

    /**
     * @description: 中间有障碍物
     * @author sunfch
     * @date 2020/7/7 17:03
     */
    public static int method(int[][] arr) {

        int[][] dp = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length && arr[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < arr[0].length && arr[0][i] == 0; i++) {
            dp[0][i] = 1;
        }

        //状态方程转移,当有障碍物,就是原数组中有0 存在的时候,就会跳过, ==0 就证明没有障碍物
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[arr.length - 1][arr[0].length - 1];
    }

}
