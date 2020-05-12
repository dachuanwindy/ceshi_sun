package com.Bianli_learning;

/**
 * @author sunfch
 * @create 2018-10-07 14:48
 * @desc 二分法查找实现
 **/
public class Binary_search {

    // 这个是while循环查找；
    public static int Binary_search(int value[], int finalvalue) {
        int length = value.length;
        if (length == 0) {
            return -1;
        }
        int start = 0;
        int right = length - 1;
        while (start <= right) {
            int middle = (right + start) / 2;
            if (value[middle] == finalvalue) {
                return finalvalue;
            } else if (value[middle] > finalvalue) {
                right = middle - 1;
            } else {
                System.out.println("向右查找" + middle);
                start = middle + 1;
            }
        }
        return -1;
    }

    // 递归实现,必须知道开始位置和结束位置
    public static int binary_find(int arr[], int start, int end, int finalvalue) {
        if (arr.length == 0)
            return -1;
        if (start <= end) {
            int middle = (start + end) / 2;
            if (arr[middle] == finalvalue) {
                return finalvalue;
            } else if (arr[middle] > finalvalue) {
                return binary_find(arr, start, middle - 1, finalvalue);
            } else {
                return binary_find(arr, middle + 1, end, finalvalue);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12};
        int result = Binary_search(arr, 5);
        System.out.println(result);
        System.out.println("================================");
        int reslut1 = binary_find(arr, 0, arr.length - 1, 12);
        System.out.println("======>" + reslut1);
    }
}
