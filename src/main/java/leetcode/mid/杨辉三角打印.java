package leetcode.mid;

import java.util.Scanner;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 这个是通过数组方式实现
 * @date 2020/6/2 10:21
 */
public class 杨辉三角打印 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        replace(nextInt);
    }

    private static void replace(int nextInt) {

        int ints[][] = new int[nextInt][nextInt];
        for (int row = 0; row < nextInt; row++) {
            if (row == 0) {
                ints[0][0] = 1;
            } else if (row == 1) {
                ints[1][0] = 1;
                ints[1][1] = 1;
            }
            for (int column = 0; column <= row; column++) {
                if (column == 0) {
                    ints[row][0] = 1;
                } else if (column == row) {
                    ints[row][column] = 1;
                } else {
                    ints[row][column] = ints[row - 1][column]
                            + ints[row - 1][column - 1];
                }
            }
        }
        print(ints);
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
