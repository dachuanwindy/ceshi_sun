package leetcode.专项.二分法;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 33. 搜索旋转排序数组
 * @date 2020/7/25 16:50
 */
public class 搜索旋转排序数组 {

    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int method = method(arr, 0);
        System.out.println(method);
    }

    /**
     * @description: 旋转数组中找值
     * @author sunfch
     * @date 2020/7/25 16:51
     */
    public static int method(int[] arr, int target) {

        int left =0;
        int right =  arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            //判断是在左半边,还是有半边,
            if (target >= arr[0]) {
                if (arr[mid] < arr[0]) {
                    arr[mid] = Integer.MAX_VALUE;
                }
            } else {
                if (arr[mid] >= arr[0]) {
                    arr[mid] = Integer.MIN_VALUE;
                }
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else  {
                right = mid - 1;
            }
        }
        return -1;
    }
}
