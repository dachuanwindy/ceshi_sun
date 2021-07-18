package inspur;

import java.util.Arrays;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 寻找第K大
 * 限定语言：Python、C++、C#、Java
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 * <p>
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
 * <p>
 * 测试样例：
 * [1,3,5,2,2],5,3
 * 返回：2
 * @date 2020/8/11 11:22
 */
public class TestMain2 {

    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 2, 2};
        int kth = findKth(arr, 5, 3);
        System.out.println(kth);


        sort(arr, 0, 5);

        System.out.println("");

    }


    /**
     * @description: 实现
     * @author sunfch
     * @date 2020/8/11 11:27
     */
    public static int findKth(int[] a, int n, int K) {

        Arrays.sort(a);
        System.out.println(a[n - 3]);
        return a[n - 3];
    }


    /**
     * @description: 快排序实现
     * @author sunfch
     * @date 2020/8/11 11:28
     */
    public static void sort(int[] arr, int start, int end) {

        int base = arr[start];
        int i = start;
        int j = end;
        int temp;
        while (i < j) {
            while (i < j && arr[base] > arr[i]) i++;
            while (i < j && arr[base] < arr[j]) j--;
            if (i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (i < end) {
            sort(arr, i, end);
        }

        if (j > start) {
            sort(arr, start, j);
        }
    }
}
