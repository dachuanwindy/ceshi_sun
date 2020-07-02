package leetcode.hard;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 面试中比较多  4
 * <p>
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/29 16:35
 */
public class 寻找两个正序数组的中位数 {

    public static void main(String[] args) {
        System.out.println("中位数====");
    }

    /**
     * @description: 这个题比较难, 中位数是-==== 排序后中间的值,奇数个就是中间值,  偶数个就是中间两个值就和/2
     * @author sunfch
     * @date 2020/6/29 16:48
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
//            奇数个
            int midValue = findMidValue(nums1, nums2, totalLength / 2 + 1);
            return midValue;
        } else {
            int index1 = totalLength / 2 - 1;
            int index2 = totalLength / 2;
            int midValue = findMidValue(nums1, nums2, index1 + 1);
            int midValue2 = findMidValue(nums1, nums2, index2 + 1);
            return (midValue + midValue2) / 2.0;
        }
    }

    /**
     * description: 有序数组的中位数: 就是找到第K小的值, 其中K=length/2;
     * <p>
     * 然后不断缩小k的值,知道K==1 ,就是中位数的值 ;本题的思路就就是这么做的
     *
     * @param num1
     * @param num2
     * @param k    中位数
     * @return int
     */
    public static int findMidValue(int[] num1, int[] num2, int k) {

        int length1 = num1.length;
        int length2 = num2.length;

        int index1 = 0;
        int index2 = 0;
        int kthElement = 0;

        while (true) {

            //边界情况
            if (index1 == length1) {
                return num2[index2 + k - 1];
            }
            if (index2 == length2) {
                return num1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(num1[index1], num2[index2]);
            }
            //中位数的一半
            int half = k / 2;

            //数组1中 第一半的数-1;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            //数组2 中第一半的书-1
            int newIndex2 = Math.min(index2 + half, length2) - 1;

            int pivot1 = num1[newIndex1];
            int pivot2 = num2[newIndex2];

            // 剔除掉 二分之一 的二分之一;
            if (pivot1 <= pivot2) {
                k = k - (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k = k - (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }

    }
}
