package leetcode.easy.niuke;

import java.util.LinkedList;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 实现字符串解码
 * 字符串解码
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class 字符串解码 {

    public static void main(String[] args) {
        System.out.println("实现字符串解码");

    }

    public static void method1(String s) {
        int multi = 0;
        //压栈
        LinkedList char_list = new LinkedList();
        //数字统计;
        LinkedList num_list = new LinkedList();
        StringBuilder res = new StringBuilder();

        for (Character c : s.toCharArray()) {
            if (c.equals("[")) {


            } else if (c.equals("]")) {

            } else if (c >= '0' && c <= '9') {

            } else {
                res.append(c);
            }
        }


    }

    /**
     * description: 官方解法
     *
     * @param s
     * @return java.lang.String
     */
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }


}
