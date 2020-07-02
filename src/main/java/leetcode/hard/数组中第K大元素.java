package leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/29 15:24
 */
public class 数组中第K大元素 {

    public static void main(String[] args) {
        System.out.println("找到数组中的第K大元素");
        int arr[] = {3, 2, 1, 5, 6, 4};
        int kthLargest = findKthLargest(arr, 2);

        System.out.println(kthLargest);
        int i = method2(arr, 2);
        System.out.println("利用堆来实现====" + i);
    }

    /**
     * @description: 方式一 先排序再找======> 这个题主要考察排序
     * @author sunfch
     * @date 2020/6/29 15:25
     */
    public static int findKthLargest(int[] nums, int k) {
        //  quickSort(nums, 0, nums.length-1);
        Arrays.sort(nums);
        int value = nums[nums.length - k];
        return value;
    }

    public static void quickSort(int[] num, int left, int right) {

        int i = left;
        int j = right;
        int base = num[left];
        if (i > j) {
            return;
        }

        while (i < j) {
            while (num[i] < base && i < right) i++;
            while (num[j] > base && left < j) j--;
            if (i <= j) {
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
                i++;
                j--;
            }
        }
        if (left < j) {
            quickSort(num, left, j);
        }
        if (i < right) {
            quickSort(num, i, right);
        }
    }


    /**
     * @description: 利用堆来实现
     * @author sunfch
     * @date 2020/6/29 16:13
     */
    public static int method2(int[] arr, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return  o2 -o1;
            }
        });

        priorityQueue.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (priorityQueue.peek() >= arr[i]) {
                priorityQueue.add(arr[i]);
            }
        }
        return priorityQueue.peek();
    }
}