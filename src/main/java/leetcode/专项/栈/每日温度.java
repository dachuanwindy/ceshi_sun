package leetcode.专项.栈;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 739题
 * <p>
 * <p>
 * 做题心得: 数组+stack的形式存储信息,
 * 绝大数情况是:stack[]只能存储数组的下标, 要是存储数组的值,就没有意义了.
 * <p>
 * 本题是这样的:
 * @date 2020/6/23 09:07
 */
public class 每日温度 {

    public static void main(String[] args) {
        System.out.println("每日问题");

        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = dailyTemperatures(arr);
        System.out.println(ints);
    }

    public static int[] dailyTemperatures(int[] T) {
        int[] arr = new int[T.length];
        Arrays.fill(arr, 0);
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < T.length; i++) {
            //今天比昨天温度低,就放进去;后面再比较计算
            // T[i] > T[stack.peek()]  当今天的问题 大于栈顶保存的那天的温度的时候,进行比较
            while (stack.peek() != -1 && T[i] > T[stack.peek()]) {
                int cur = stack.pop();
                arr[i] = i - cur;
            }
            stack.push(i);
        }
        return arr;
    }
}
