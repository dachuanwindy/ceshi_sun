package leetcode.专项.滑动窗口;

import org.apache.lucene.util.Bits;

import java.util.HashMap;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 76 题
 * <p>
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/17 09:11
 */
public class 最小覆盖子串问题 {

    public static void main(String[] args) {
        System.out.println("最小覆盖子串问题");
        String s = minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }

    /**
     * @description: 通过滑动窗口实现
     * @author sunfch
     * @date 2020/6/17 09:12
     */
    public static String minWindow(String s, String t) {


        //源字符串;
        char[] chars = new char[s.length()];
        // 要验证的字符串
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (t.charAt(i) == s.charAt(j)) {
                    chars[j] = s.charAt(j);
                }
            }
        }
        //第二步:将这个char
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int min = 0;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                min = Math.min(min, i-left);
                left = Math.max(left, map.get(chars[i]) + 1);
            }
            map.put(chars[i], i);

        }


        return "";
    }

}
