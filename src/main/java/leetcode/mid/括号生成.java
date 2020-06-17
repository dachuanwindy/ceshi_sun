package leetcode.mid;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 生成有效括号
 * <p>
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/16 03:36
 * <p>
 * <p>
 * 解决思路: 深度优先和广度优先两个算法
 */
public class 括号生成 {

    public static void main(String[] args) {

        // 1 采用深度优先策略实现生成括号--时间复杂度为 n
        List<String> strings = generateParenthesis(3);
        System.out.println(strings);

        List<String> strings1 = generateParenthesis2(3);
        System.out.println("====>" + strings1);

        List<String> strings2 = Dp(2);
        System.out.println(strings2);
    }

    /**
     * @description: 采用深度优先算法
     * 深度优先:一通到底,然后回溯
     * @author sunfch
     * @date 2020/6/16 07:37
     */
    public static List<String> generateParenthesis(int n) {
        List<String> listStr = new ArrayList<String>();
        dsf("", 0, 0, n, listStr);
        return listStr;
    }

    public static void dsf(String str, int left, int right, int n, List<String> listStr) {
        // 此时递归结束,返回各种情况
        if (left == n && right == n) {
            listStr.add(str);
            return;
        }
        if (left < right) {
            return;
        }
        if (left < n) {
            dsf(str + "(", left + 1, right, n, listStr);
        }
        if (right < n) {
            dsf(str + ")", left, right + 1, n, listStr);
        }
    }


    /**
     * @description: 采用广度优先策略实现
     * <p>
     * 广度优先就是按照
     * @author sunfch
     * @date 2020/6/16 08:06
     */
    public static List<String> generateParenthesis2(int n) {
        List<String> listStr = new ArrayList<String>();

        NodeStr nodeStr = new NodeStr("", n, n);
        Queue<NodeStr> queue = new ArrayDeque<>();
        queue.add(nodeStr);

        while (!queue.isEmpty()) {
            NodeStr node = queue.poll();
            if (node.left == 0 && node.right == 0) {
                System.out.println(node.str);
                listStr.add(node.str);
            }
            if (node.left > 0) {
                queue.offer(new NodeStr(node.str + "(", node.left - 1, node.right));
            }
            if (node.right > 0 && node.left < node.right) {
                queue.offer(new NodeStr(node.str + ")", node.left, node.right - 1));
            }
        }
        return listStr;
    }

    /**
     * @description: 采用动态规划
     * @author sunfch
     * @date 2020/6/16 11:16
     */
    public static List<String> gen(int n) {
        ArrayList<String> strings = new ArrayList<>();


        return strings;

    }

    public static List<String> generateParenthesis3(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        // 这里 dp 数组我们把它变成列表的样子，方便调用而已
        List<List<String>> dp = new ArrayList<>(n);

        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);

        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        // 枚举右括号的位置
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }


    public static List<String> Dp(int n) {

        //定义dp
        List<List<String>> dp = new ArrayList<>(n);
        //定义初始值 base 并赋值
        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);

        //第三步:状态转移方程
        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - j - 1);
                for (String str11 : str1) {
                    for (String str22 : str2) {
                        cur.add("(" + str11 + ")" + str22);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }

}

class NodeStr {

    String str;
    int left;
    int right;

    NodeStr(String str, int left, int right) {
        this.str = str;
        this.left = left;
        this.right = right;
    }
}


//总结:
/**
 * 深度优先采用的是栈---->基本实现方法是递归
 * <p>
 * 广度优先采用是队列--->一排 一排的输出,  采用的是while()循环的方式
 */