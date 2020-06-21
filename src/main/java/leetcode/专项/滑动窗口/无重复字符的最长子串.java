package leetcode.专项.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 滑动窗口专项练习
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/17 08:47
 */
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        System.out.println("滑动窗口专项练习");

        int i = lengthOfLongestSubstring("abcabcbb");
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            // 如何在map中存在,就是这种情况 abacd 这个时候的left=第二个a的位置坐标
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
