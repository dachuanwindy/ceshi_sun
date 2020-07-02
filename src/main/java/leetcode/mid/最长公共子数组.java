package leetcode.mid;

import DTO.User;
import Java_JC.FanXing_study.Person;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 最长重复子数组
 * 718. 最长重复子数组
 * <p>
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/7/1 23:26
 */
public class 最长公共子数组 {

    public static void main(String[] args) {
        User user =new User();
        method(2, user);
        System.out.println(user.toString());

    }

    public static int method(int a, User b) {
        b.setName("sunfengc");
        return a;
    }

    /**
     * @description: 第一种方式: 动态规划
     * @author sunfch
     * @date 2020/7/2 06:32
     */
    public static int find(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        //从大到遍历
        for (int i = n - 1; i >= 0; i--) {
            // 也是从大到小遍历
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(dp[i][j], ans);
            }
        }
        return ans;
    }

    /**
     * @description: 第二种实现方式, 滑动窗口
     * @author sunfch
     * @date 2020/7/2 06:41
     */

    public static int findMaxLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {


        }

        return 0;

    }


}
