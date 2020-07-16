package leetcode.专项.动态规划;

import java.util.HashMap;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 1143
 * <p>
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * @date 2020/7/8 15:47
 */
public class 最长公共子序列问题 {

    public static void main(String[] args) {
        System.out.println("最长公共子序列问题");


        int result = 2 << 1;

        int ans2 = 4 >>> 1;


        String t1 = "12";
        String t2 = "eeee34";
        int method = method(t1, t2);
        System.out.println(method);
        HashMap map = new HashMap();
        //map.put()
    }

    public static int method(String text1, String text2) {

        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();

        //初始化动态方程;
        int[][] dp = new int[t1.length + 1][t2.length + 1];
        //这个开始循环遍历
        for (int i = 1; i < t1.length + 1; i++) {
            for (int j = 1; j < t2.length + 1; j++) {
                //如果是相等,就把这个值加1
                if (t1[i - 1] == t2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[t1.length][t2.length];
    }
}
