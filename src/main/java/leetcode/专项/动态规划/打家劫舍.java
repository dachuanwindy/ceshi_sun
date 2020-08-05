package leetcode.专项.动态规划;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 198. 打家劫舍
 * 动态规划题目
 * @date 2020/7/16 18:55
 */
public class 打家劫舍 {
    public static void main(String[] args) {
        System.out.println("打家劫舍,利用动态规范去做");

        int[] arr = {1, 2, 3, 1};
        int[] arr2 = {2, 7, 9, 3, 1};
        int rob = rob(arr2);
        System.out.println(rob);
    }

    /**
     * @description: 技术总结
     * 1.第一次选取与后面有关系,所以要记录,这样就会想到动态规划去解答这个题;
     * 2.拿到最大值,然后加上后面的值,还是要取最大的值存起来,供给后面使用;
     * 这也是动态规划的一种思路吧.
     * @author sunfch
     * @date 2020/7/16 19:15
     */
    public static int rob(int[] arr) {

        if (arr.length == 0) {
            return 0;
        }
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i] = dp[i - 2] + arr[i], dp[i - 1]);
        }
        return dp[arr.length - 1];
    }
}
