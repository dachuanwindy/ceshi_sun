package leetcode.easy.niuke;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 无重复的最长子串Java实现
 * @date 2020/5/22 13:56
 */
public class 无重复的最长子串 {

    public static void main(String[] args) {

        String method = method2("abcddd");
        System.out.println(method);
    }

    // 暴力解决方案:
    public static String method(String str) {

        // 首先拿到整个字符串
        for (int i = str.length(); i > 0; i--) {
            for (int j = 0; j <= str.length() - i; j++) {
                String sub = str.substring(j, i + j);
                char[] chars = sub.toCharArray();
                HashSet<Character> characters = new HashSet<>();
                for (char c : chars) {
                    characters.add(c);
                }
                if (characters.size() == sub.length()) {
                    return sub;
                }
            }
        }
        return null;
    }


    // 方案2 滑动窗口
    public static String method2(String str) {
        int[] chars = new int[128];
        Arrays.fill(chars, -1);

        int left = 0;
        int right = 0;
        for (int i = 0; i < str.length(); i++) {

        }

        System.out.println(chars[3]);
        return "";
    }
}
