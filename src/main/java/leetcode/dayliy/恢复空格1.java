package leetcode.dayliy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO        链接：https://leetcode-cn.com/problems/re-space-lcci
 * @date 2020/7/9 17:09
 */
public class 恢复空格1 {

    public static void main(String[] args) {
        String[] dictionary = {"looked", "just", "like", "her", "brother"};
        String sentence = "jesslookedjustliketimherbrother";
        int respace = method2(dictionary, sentence);
        System.out.println(respace);

    }


    /**
     * @description: 这个思路, 刚开始还可以, 但是不能实现,
     * @author sunfch 错误 ❌
     * @date 2020/7/10 00:12
     */
    public static int respace(String[] dictionary, String sentence) {

        for (int i = 0; i < dictionary.length; i++) {
            if (sentence.contains(dictionary[i])) {
                sentence = sentence.replaceAll(dictionary[i], "");
            }
        }
        System.out.println(sentence);
        System.out.println(sentence.length());
        return sentence.length();
    }


    /**
     * @description: 采用动态规划做这个题
     * @author sunfch
     * @date 2020/7/10 00:14
     * <p>
     * 题目的意思有点像 最少的硬币组合, 11 =1+5+5, 三种就可以
     * abcdefeg  abc是因子;
     */
    public static int method2(String[] dic, String sentence) {

        Set<String> dic2 = new HashSet<>(Arrays.asList(dic));
        int[] dp = new int[sentence.length() + 1];

        dp[0] = 0;
        int k = 0;
        for (int i = 1; i <= sentence.length(); i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = k; j < i; j++) {
                if (dic2.contains(sentence.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                    k = i;
                }
            }
        }
        return dp[sentence.length()];
    }

}
