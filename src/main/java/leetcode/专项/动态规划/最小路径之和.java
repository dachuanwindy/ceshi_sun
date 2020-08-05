package leetcode.专项.动态规划;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 最小路径之和, 这样题目, 基本上都是用动态规划去做.
 * @date 2020/7/25 15:48
 */
public class 最小路径之和 {

    public static void main(String[] args) {
        int[][] arr = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int i = minPath(arr);
        System.out.println(i);
    }

    /**
     * @description: 已经通过 技术总结:
     * 动态规划路径题目--->
     * 1.状态转移方程找到  2.初始变量定义   3. 当前值与之前的路经营有关系;
     * @author sunfch
     * @date 2020/7/25 16:36
     */
    public static int minPath(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    arr[i][j] = arr[i][j - 1] + arr[i][j];
                } else if (j == 0) {
                    arr[i][j] = arr[i][j] + arr[i - 1][j];
                } else {
                    arr[i][j] = Math.min(arr[i][j - 1], arr[i - 1][j]) + arr[i][j];
                }
            }

        }
        return arr[arr.length - 1][arr[0].length - 1];
    }
}
