package leetcode.easy.soeasy;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 一个n*n 数组,循环打印
 * @date 2020/6/5 19:08
 */
public class 打印数组 {
    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] method = method(matrix);
        System.out.println(method);
    }

    /**
     * description:
     * 1 2 3
     * 4 5 6
     * 7 8 9
     *
     * @param matrix
     * @return void
     */
    public static int[] method(int[][] matrix) {

        int row = matrix.length;
        //行
        int column = matrix[0].length;
        //列
        int arr[] = new int[row * column - 1];
        //列管理
        int left = 0;
        int right = column - 1;
        // 行管理
        int head = 0;
        int end = row - 1;
        int start = -1;
        while ((left < right) || (head < end)) {
            //行
            for (int i = left; i < right; ++i) {
                //  System.out.println(matrix[left][i]);
                start++;
                arr[start] = matrix[left][i];
            }
            //竖
            for (int i = head; i < end; i++) {
                // System.out.println(matrix[i][right]);
                start++;
                arr[start] = matrix[i][right];
            }


            //横 反转
            for (int i = right; i > left; i--) {
                //  System.out.println(matrix[end][i]);
                start++;
                arr[start] = matrix[end][i];
            }

            for (int i = end; i > head; i--) {
                //  System.out.println(matrix[i][left]);
                start++;
                arr[start] = matrix[i][left];
            }

            left++;
            right--;
            head++;
            end--;
        }
        start--;
        if (head == end) // 剩下一行，从左到右依次添加
        {
            for (int i = left; i <= right; i++) {
                arr[start++] = matrix[head][i];
            }
        } else if (left == right) // 剩下一列，从上到下依次添加
        {
            for (int i = head; i <= end; i++) {
                arr[start++] = matrix[i][left];
            }
        }
        return arr;

    }
}
