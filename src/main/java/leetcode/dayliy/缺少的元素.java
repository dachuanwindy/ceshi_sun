package leetcode.dayliy;

import java.util.ArrayList;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 442
 * @date 2020/7/24 23:28
 */
public class 缺少的元素 {

    public static void main(String[] args) {

        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        method2(arr);
    }

    /**
     * @description: 这个方式, 实现了数组的排序;, 这种方式不可行
     * @author sunfch
     * @date 2020/7/24 23:53
     */
    public static void method(int[] arr) {


        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                result.add(arr[i]);
            }
        }
        System.out.println("arr" + result.toString());
    }

    /**
     * @description: 利用重复数据实现;
     * @author sunfch
     * @date 2020/7/25 00:07
     */
    public static void method2(int[] arr) {

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i])-1;
            if (arr[index] < 0) {
                result.add(Math.abs(arr[index]));
            } else {
                arr[index] = -arr[index];
            }
        }

        System.out.println(result.toString());
    }
}
