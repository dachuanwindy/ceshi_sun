package leetcode.easy.niuke;

import java.util.Arrays;

/**
 * @author sunfch
 * @version V1.0
 * @Description:
 * @date 2020/3/23 15:23
 */
public class Leetcode2 {


    public static void main(String[] args) {
        int[] a = {3, 6, 2, 9, 1, 10, 7, 8, 12, 24, 15, 19};
        int k = 20;
        sum_k(a, k);
    }

    /**
     * @description: 一个数组中，求两个数相加等于某个值====
     * <p>
     * 解题思路：先排序，然后这样就能根据排序
     * @author sunfch
     * @date 2020/3/23 15:25
     */
    public static void sum_k(int[] arr, int k) {

        Arrays.sort(arr);
        int front = 0;
        int end = arr.length - 1;
        while (front < end) {
            if (arr[front] + arr[end] == k) {
                System.out.println(arr[front] + "," + arr[end]);
                front++;
                end--;
            } else if (arr[front] + arr[end] < k) {
                front++;
            } else {
                end--;
            }
        }
    }


    public static void Sun_k(int[] arr, int K) {

        Arrays.sort(arr);

        int front = 0;
        int end = arr.length - 1;

        while (front < end) {
            if (arr[front] + arr[end] == K) {
                System.out.println("key1==" + arr[front] + ",key2 ==" + arr[end]);
                front++;
                end--;
            }
            if (arr[front] + arr[end] < K) {
                front++;
            }else {
                end--;
            }
        }
    }
}
 /**
  *
  * 针对有序数组： 两个数之和
  *
  * */

