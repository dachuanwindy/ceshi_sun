package leetcode.easy.niuke;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 最长回文子串 暴力解决方案
 * @date 2020/5/22 14:39
 */
public class 最长回文子串 {

    public static void main(String[] args) {
        System.out.println("最长回文子串");

        String ss = "aabcbaa";
        String replace = ss.replace("", "#");
        System.out.println(replace);
        String s = longestPalindrome(ss);
        System.out.println(s);

    }


    public static String huiWen() {
        String str = "abccba";

        for (int i = str.length(); i > 0; i--) {


            for (int j = 0; j < str.length() - i; j++) {
                String sub = str.substring(j, j + i);
                //判断子串是否对象;

                char[] chars = sub.toCharArray();
                for (int k = 0; k < chars.length / 2; k++) {


                }

            }

        }

        return null;

    }


    /**
     * description:
     *
     * @param str
     * @return java.lang.String
     */
    public static String longestPalindrome(String str) {
        //给每两个字母中间插上特殊符号
        str = str.replace("", "#");

        //记录一下回文子串的开始位置和最大长度 当然,记录结束位置也可以
        int start = 0;
        int max = 0;

        //遍历所有字母
        for (int i = 0; i < str.length(); i++) {

            //以当前字母为中心
            int left = i;
            int right = i;

            //向前向后同时遍历，直到不再对称为止
            while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                left--;
                right++;
            }

            //计算长度
            int thisTimeLength = right - left - 1;

            //如果长度比最大长度大则更新最大长度和起始位置
            if (thisTimeLength > max) {
                max = thisTimeLength;
                start = left + 1;
            }
        }
        //最终删掉我们加入的特殊符号#，返回字串
        return str.substring(start, start + max).replaceAll("#", "");
    }


    /**
     * @description: 替换---解决奇数偶数问题
     * @author sunfch
     * @date 2020/7/2 11:21
     */
    static String HuiWen(String str) {

        str = str.replace("", "#");
        int max = 0;
        int start = 0;

        for (int i = 0; i < str.length(); i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right <= str.length() && str.charAt(left) == str.charAt(right)) {
                left--;
                right++;
            }
            int thisLength = right - left - 1;
            if (thisLength > max) {
                max = thisLength;
                start = left + 1;
            }
        }
        return str.substring(start, start + max).replace("#", "");
    }
}
