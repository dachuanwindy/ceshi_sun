package leetcode.easy.soeasy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 1
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/29 15:10
 */
public class 两数之和 {

    public static void main(String[] args) {
        System.out.println("两数之和==K");
    }

    // 利用hash表去做
    public static void twoSum(int[] nums, int target) {

        int[] ints = new int[2];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsValue(target - nums[i])) {
                System.out.println(nums[i] + "====" + (target - nums[i]));
            }
        }
    }


    /**
     * @description: 两数之和用双指针去做  这个必须是有序数组.
     * @author sunfch  通过 简单;
     * @date 2020/7/21 18:50
     */
    public static int[] twoSums(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        while (low < high) {

            if (arr[low] + arr[high] == target) {
                return new int[]{low + 1, high + 1};
            }
            if (arr[low] + arr[high] > target) {
                high--;
            } else {
                low++;
            }
        }
        return new int[]{-1, -1};
    }


}
