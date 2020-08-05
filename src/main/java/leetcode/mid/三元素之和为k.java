package leetcode.mid;

import java.util.Arrays;
import java.util.List;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 15
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/29 14:57
 */
public class 三元素之和为k {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> threeSum(int[] nums) {

        //首先对数组进行排序
        Arrays.sort(nums);
        //双指针法求解问题
        return null;

    }


    /**
     * @description: 最大子序列乘积
     * @author sunfch
     * @date 2020/7/25 12:02
     */
    public static int method(int[] arr) {

        int[][] dp = new int[arr.length][2];
        dp[0][0] = arr[0];
        dp[0][1] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > 0) {
                dp[i][0] = Math.min(arr[i], arr[i] * dp[i - 1][0]);
                dp[i][1] = Math.max(arr[i], arr[i] * dp[i - 1][1]);
            } else {
                dp[i][0] = Math.min(arr[i], arr[i] * dp[i - 1][1]);
                dp[i][1] = Math.max(arr[i], arr[i] * dp[i - 1][0]);
            }
        }
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            maxVal = Math.max(dp[i][1], maxVal);
        }
        return maxVal;
    }

}
