package leetcode.easy.soeasy;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 能说的过去;
 * @date 2020/6/1 23:18
 */
public class 重复元素判断 {

    public static void main(String[] args) {

        int[] ints = {1, 2, 3, 1};
        boolean b = containsNearbyDuplicate(ints, 3);
        System.out.println(b);

    }

    static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length - k; i++) {
            for (int j = i; j < (i + k); j++) {
                if (i != j && nums[j] == nums[i]) {
                    return true;
                }
            }
        }
        return false;
    }
}
