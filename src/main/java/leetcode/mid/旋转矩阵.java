package leetcode.mid;

import java.util.List;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 54
 * <p>
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/29 23:15
 */
public class 旋转矩阵 {

    public static void main(String[] args) {

    }

    /**
     * @description: 旋转矩阵输出 : 思路就是这么实现的;
     * @author sunfch
     * @date 2020/6/29 23:16
     */
    public static List<Integer> spiralOrder(int[][] matrix) {

        int length = matrix.length;
        int high = matrix[0].length;

        //行输出           从上到下            从右到左                      从下到上
        int left_right = 0, top_bottom = 0, right_left = left_right - 1, bottom_top = high - 1;
        while (left_right <= right_left && top_bottom <= bottom_top) {
            for (int i = 0; i < length - 1; i++) {
                System.out.println(matrix[i][0]);
            }
            for (int i = 0; i < high - 1; i++) {
                System.out.println(matrix[0][i]);
            }
            //列输出

            //行反向输出

            //列反向输出
        }
        return null;
    }
}
