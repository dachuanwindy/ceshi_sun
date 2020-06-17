package leetcode.hard;

import leetcode.easy.soeasy.有效括号;

import java.util.Stack;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * <p>
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/16 13:58
 */
public class 最长有效括号 {

    public static void main(String[] args) {
        System.out.println("最长有效括号");

        int i = method2("()()()(())");
        System.out.println(i);
    }


    /**
     * @description: 暴力解决方案
     * <p>
     * 时间为 O(n3)
     * @author sunfch
     * @date 2020/6/16 14:38
     */
    public static int method(String s) {

        if (s == "" || s == null) {
            return 0;
        }
        int max = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = chars.length; j > 0; j--) {
                String sub = s.substring(i, j);
                if (有效括号.isValid(sub)) {
                    max = sub.length();
                }
            }
        }
        return max;
    }

    /**
     * @description: 最方便的解法就是利用栈来解决
     * @author sunfch
     * @date 2020/6/16 15:17
     */
    public static int method2(String s) {

        Stack<Integer> stack = new Stack();

        stack.add(-1);

        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
