package leetcode.easy.soeasy;

import java.util.Stack;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/16 12:41
 */
public class 有效括号 {

    public static void main(String[] args) {
        boolean valid = isValid("([)]");
        System.out.println(valid);
    }

    /**
     * @description: 第一种方式:stack
     * @author sunfch
     * @date 2020/6/16 12:42
     */

    public static boolean isValid(String s) {

        if (s == null || s == "") {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if (!stack.isEmpty()) {
                Character peek = stack.peek();

                if (peek.equals('(') && ')' == chars[i]) {
                    stack.pop();
                    continue;
                }
                if (peek.equals('{') && '}' == chars[i]) {
                    stack.pop();
                    continue;
                }
                if (peek.equals('[') && ']' == chars[i]) {
                    stack.pop();
                    continue;
                }
            }
            if(chars[i]=='[' || chars[i]==']' || chars[i]=='{' || chars[i]=='}' || chars[i]=='(' || chars[i]==')' ){
                stack.push(chars[i]);

            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
