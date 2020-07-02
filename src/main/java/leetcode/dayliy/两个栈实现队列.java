package leetcode.dayliy;

import java.util.Stack;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 使用两个栈实现一个队列
 * 分析:栈的特性: 后进先出,
 * @date 2020/6/29 13:38
 */
public class 两个栈实现队列 {


    public static void main(String[] args) throws Exception {

        两个栈实现队列.push(1);
        两个栈实现队列.push(2);
        两个栈实现队列.push(3);
        两个栈实现队列.push(4);
        两个栈实现队列.push(5);

        System.out.println(两个栈实现队列.pop());
        System.out.println(两个栈实现队列.pop());
        System.out.println(两个栈实现队列.pop());
        System.out.println(两个栈实现队列.pop());

    }

    public static Stack<Integer> stack1 = new Stack<>();
    public static Stack<Integer> stack2 = new Stack<>();

    //入栈
    public static void push(int value) {
        stack1.push(value);
    }

    /**
     * @description: 出栈
     * @author sunfch
     * @date 2020/6/29 13:41
     */
    public static int pop() throws Exception {

        if (stack2.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}