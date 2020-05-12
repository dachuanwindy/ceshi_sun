package leetcode.easy.niuke;


import Test_1.ThrealLocal_study;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author sunfch
 * @version V1.0
 * @Description:  判断输入信息是否正确，
 * true and false 返回 true
 * true or false and false 返回true；
 * and true  返回 error  不能正确判断就返回error
 *
 * @date 2020/3/23 08:53
 * <p>
 * 链接：https://www.nowcoder.com/questionTerminal/e06d50b938d24a2b8a2c14edebee5478?f=discussion
 * 来源：牛客网
 */

public class BooleanCheck {

    public static void Main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] splits = line.split(" ");
        if (splits[splits.length - 1].equals("and") || splits[splits.length - 1].equals("or")) {
            System.out.println("error");
            return;
        }
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < splits.length; i++) {
            String temp = splits[i];
            if (i % 2 == 0 && (temp.equals("or") || temp.equals("and"))) {
                System.out.println("error");
                return;
            } else if (i % 2 == 1 && (temp.equals("true") || temp.equals("false"))) {
                System.out.println("error");
                return;
            } else {
                if (temp.equals("and")) {
                    temp = stack.pop();
                    temp = temp.equals("false") || splits[i + 1].equals("false") ? "false" : "true";
                    stack.push(temp);
                    i++;
                } else {
                    stack.push(temp);
                }
            }
        }

        while (!stack.isEmpty()) {
            String istrue = stack.pop();
            if (istrue.equals("true")) {
                System.out.println("true");
                return;
            }
        }
        System.out.println("false");
        return;
    }

}