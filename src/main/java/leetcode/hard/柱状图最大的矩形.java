package leetcode.hard;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 84题 经典
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * <p>
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/23 07:33
 */
public class 柱状图最大的矩形 {


    public static void main(String[] args) {
        System.out.println("柱状体最大矩形面积");

        int[] arr = {2, 1, 5, 6, 2, 3};
        int i = largestRectangleArea(arr);
        System.out.println(i);


    }

    /**
     * @description: 暴力解决方案 : 边界问题没有处理好;
     * @author sunfch
     * @date 2020/6/23 07:37
     */
    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int maxValue = 0;
        for (int i = 0; i < heights.length; i++) {
            // 以 i 为中心, 判断这个值的右边界值
            int centerValue = heights[i];
            int right = heights.length;
            int left = i;
            for (int j = i + 1; j < heights.length; j++) {
                if (centerValue > heights[j]) {
                    right = j;
                    break;
                }
            }
            // 以 i 为中心, 判断这个值的左边界值
            for (int j = i; j >= 0; j--) {
                if (centerValue < heights[j]) {
                    left = j;
                    break;
                }
            }
            int temp = (right - left) * centerValue;
            maxValue = Math.max(maxValue, temp);
        }

        return maxValue;
    }


    /**
     * @description: 采用栈的方式解决
     * @author sunfch
     * @date 2020/6/23 09:05
     */
    public static int method2() {


        return 0;
    }
}
