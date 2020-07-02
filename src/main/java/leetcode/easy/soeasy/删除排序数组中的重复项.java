package leetcode.easy.soeasy;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 删除排序数组中的重复项
 * @date 2020/6/29 14:35
 */
public class 删除排序数组中的重复项 {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2};
        int i = removeDuplicates(arr);
        System.out.println(i);
    }

    public static int removeDuplicates(int[] nums) {

        //记录两个指针;
        int slow = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[slow]) {
                slow++;
                nums[slow] = nums[i];
            }
        }
        return slow + 1;
    }
}