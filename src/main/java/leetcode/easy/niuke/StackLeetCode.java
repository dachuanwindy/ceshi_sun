package leetcode.easy.niuke;

import java.util.Stack;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 有效括号: (){}[]  返回true; [{]] 返回false
 * @date 2020/3/29 15:51
 */
public class StackLeetCode {
    public static void main(String[] args) {

        String data = "{}{{}}[]()";
        boolean b = checkWord(data);
        System.out.println(b);

    }

    public static boolean checkWord(String data) {

        int i = data.length() / 2;

        for (int j = 0; j <= i; j++) {

            if (data.contains("()")) {
                data = data.replace("()", "");
            }
            if (data.contains("{}")) {
                data = data.replace("{}", "");
            }
            if (data.contains("[]")) {
                data = data.replace("[]", "");
            }
        }
        if (data.equals("")) {
            return true;
        }
        return false;
    }

    //第二种方案是用 stack去做:成对出现,
    public static boolean checkWord2(String data) {


        Stack<Character> stack = new Stack<>();
        return false;
    }
}
