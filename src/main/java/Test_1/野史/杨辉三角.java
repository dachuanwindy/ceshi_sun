package Test_1.野史;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 自己实现杨辉三角打印
 * 两个数组
 * @date 2020/6/2 10:29
 */
public class 杨辉三角 {

    public static void main(String[] args) {
        System.out.println("哈哈哈哈");

        test(5);
    }

    public static void test(int k) {
        int[][] arr = new int[k][k];

        for (int row = 0; row < k; row++) {
            if (row == 0) {
                arr[0][0] = 1;
            } else if (row == 1) {
                arr[1][0] = 1;
                arr[1][1] = 1;
            }
            for (int column = 0; column <= row; column++) {
                //第一行补充 1
                if (column == 0) {
                    arr[row][0] = 1;
                } else
                // 最后一行补充1;
                if (column == row) {
                    arr[row][column] = 1;
                } else {
                    arr[row][column] = arr[row - 1][column] + arr[row - 1][column - 1];
                }
            }

        }
        print(arr);
    }

    private static void print(int[][] ints) {
        for (int row = 0; row < ints.length; row++) {
            for (int column = 0; column <= row; column++) {
                System.out.print(ints[row][column] + " ");
            }
            System.out.println();
        }
    }
}
