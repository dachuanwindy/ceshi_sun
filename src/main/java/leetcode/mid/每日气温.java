package leetcode.mid;

import java.util.Stack;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 每日气温, 看几天后升温;
 * @date 2020/6/3 17:34
 */
public class 每日气温 {
    public static void main(String[] args) {
        System.out.println("每日气温,什么时间升温");

        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = stackMethod(arr);
        System.out.println(ints.toString());
    }


    //方式一;
    public static int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        if (T.length == 1) {
            return result;
        }
        for (int i = 0; i < T.length; i++) {
            // 当天的值,和之后的值进行比较;
            for (int j = i; j < T.length; j++) {
                if (T[i] - T[j] < 0) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    //方式2 使用栈来实现  {73, 74, 75, 71, 69, 72, 76, 73};
    public static int[] method2(int[] T) {
        int[] result = new int[T.length];
        if (T.length == 1) {
            return result;
        }
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        for (int i = 0; i < T.length; i++) {
            while (stack.peek() != -1 && T[i] > T[stack.peek()]) {
                int cur = stack.pop();
                result[i] = i - cur;
            }
            stack.push(i);
        }
        return result;
    }


    //存放编号,然后编号相减,就是升温天数;
    public static int[] stackMethod(int[] arr) {
        int[] ints = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        //边界;
        stack.push(-1);
        for (int i = 0; i < arr.length; i++) {
            while (stack.peek() != -1 && arr[i] > arr[stack.peek()]) {
                int cur = stack.pop();
                ints[i - 1] = i - cur;
            }
            stack.push(i);
        }
        return ints;
    }
}
