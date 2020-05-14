package leetcode.easy.niuke;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 回文功能
 * @date 2020/5/13 10:55
 */
public class HuiWen {

    public static void main(String[] args) {
//        最长回文
        String str = longestPalindrome("aaabaaabbbb");
        System.out.println(str);
    }

    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        for (int i = s.length(); i > 0; i--) {
            //子串长度
            for (int j = 0; j <= s.length() - i; j++) {
                String sub = s.substring(j, i + j);
                //子串位置
                int count = 0;
                //计数，用来判断是否对称
                for (int k = 0; k < sub.length() / 2; k++) {
                    //左右对称判断
                    if (sub.charAt(k) == sub.charAt(sub.length() - k - 1)) {
                        count++;
                    }
                }
                if (count == sub.length() / 2) {
                    return sub;
                }
            }
        }
        return "";//表示字符串中无回文子串

    }

}
