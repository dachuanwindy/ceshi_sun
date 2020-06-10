package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 缺失的第一个正整数;
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/8 16:52
 */
public class 缺失的第一个正数 {

    public static void main(String[] args) {
        System.out.println("缺失的第一个正整数");
        int[] arr = {1, 4, 3, -1};
        int i = firstMissingPositive(arr);
        System.out.println(i);

        int[] ints = {4,3,2,7,8,2,3,1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(ints);
        System.out.println(disappearedNumbers);
    }

    public static int firstMissingPositive(int[] nums) {

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        //如果我的值不等于i+1; 我0的地方就该存放1;
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return len + 1;
    }

    public static void swap(int[] num, int index, int index2) {
        int temp = num[index];
        num[index] = num[index2];
        num[index2] = temp;
    }


    /**
     * @description: 同样的题型
     * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
     * <p>
     * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
     * <p>
     * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * [4,3,2,7,8,2,3,1]
     * <p>
     * 输出:
     * [5,6]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @author sunfch
     * @date 2020/6/8 17:31
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {

        ArrayList<Integer> integers = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        //如果我的值不等于i+1; 我0的地方就该存放1;
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                integers.add(i+1);
            }
        }
        return integers;
    }


}