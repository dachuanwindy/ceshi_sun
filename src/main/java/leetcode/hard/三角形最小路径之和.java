package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 三角形最小路径之和  120题
 * <p>
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/16 16:58
 */
public class 三角形最小路径之和 {

    public static void main(String[] args) {
        System.out.println("三角形最小路径之和====这个采用了dp的方式");
        List<List<Integer>> triangle = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        triangle.add(list);
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(4);
        triangle.add(list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(6);
        list2.add(5);
        list2.add(7);
        triangle.add(list2);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(4);
        list3.add(1);
        list3.add(8);
        list3.add(3);
        triangle.add(list3);

        int i = minimumTotal(triangle);
        System.out.println("输出的最小值是====>" + i);

    }


    /**
     * @description: 动态规划, 这个地方是从底向上进行
     * @author sunfch
     * @date 2020/6/16 18:11
     */
    public static int minimumTotal(List<List<Integer>> triangle) {

        //1 初始化 DP数组
        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> temp = triangle.get(i);
            for (int j = 0; j < temp.size(); j++) {
                // 动态转移方程, 从地城到上面进行相加,查找,找到最小值,
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + temp.get(j);
            }
        }
        System.out.println(dp[0][0]);
        return dp[0][0];
    }
}