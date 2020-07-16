package leetcode.dayliy;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * https://leetcode-cn.com/problems/diving-board-lcci/
 * @date 2020/7/8 16:46
 * <p>
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * <p>
 * 返回的长度需要从小到大排列。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diving-board-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 跳水板 {
    public static void main(String[] args) {
        System.out.println("跳水板问题");
        int[] method = method(1, 1, 0);
    }

    /**
     * @description: 利用数据公式来表达 " 提交成功
     * @author sunfch
     * @date 2020/7/8 16:48
     */
    public static int[] method(int shorter, int longer, int k) {

        int[] arr = new int[k + 1];
        if (k == 0) {
            return new int[0];
        }

        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        for (int i = 0; i <= k; i++) {
            int result = longer * i + shorter * (k - i);
            arr[i] = result;
            System.out.println(result);
        }
        return null;
    }


    /**
     * @description: 通过递归方式解决
     * @author sunfch
     * @date 2020/7/8 17:17
     */
    public static int[] method2(int shorter, int longer, int k) {
        return null;
    }

}
