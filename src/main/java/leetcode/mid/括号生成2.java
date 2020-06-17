package leetcode.mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/6/16 10:53
 */

public class 括号生成2 {


    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        Queue<Node2> queue = new LinkedList<>();
        queue.offer(new Node2("", n, n));

        while (!queue.isEmpty()) {

            Node2 curNode = queue.poll();
            if (curNode.left == 0 && curNode.right == 0) {
                res.add(curNode.res);
            }
            if (curNode.left > 0 ) {
                queue.offer(new Node2(curNode.res + "(", curNode.left - 1, curNode.right));
            }
            if (curNode.right > 0 && curNode.left < curNode.right) {
                queue.offer(new Node2(curNode.res + ")", curNode.left, curNode.right - 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        System.out.println(strings);
    }
}

class Node2 {
    /**
     * 当前得到的字符串
     */
    public String res;
    /**
     * 剩余左括号数量
     */
    public int left;
    /**
     * 剩余右括号数量
     */
    public int right;

    public Node2(String str, int left, int right) {
        this.res = str;
        this.left = left;
        this.right = right;
    }
}