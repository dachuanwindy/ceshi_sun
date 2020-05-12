package leetcode.easy.niuke;

import java.util.Stack;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 用栈实现对列====<这个地方必须用到两个对列
 * @date 2020/3/24 15:19
 */
public class Stack2Queue {

    private Stack<String> stackA = new Stack<>();
    private Stack<String> stackB = new Stack<>();

    public String add(String value) {
        String push = stackA.push(value);
        return push;
    }

    public String get() {
        if (stackB.isEmpty()) {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }
        String pop = stackB.pop();
        return pop;
    }
}
