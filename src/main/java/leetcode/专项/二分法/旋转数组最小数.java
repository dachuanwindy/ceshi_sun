package leetcode.专项.二分法;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 剑指 Offer 11. 旋转数组的最小数字
 * @date 2020/7/25 18:04
 */
public class 旋转数组最小数 {

    public static void main(String[] args) {

    }

    public static int method(int[] arr) {


        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }
}
