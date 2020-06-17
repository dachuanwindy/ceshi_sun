package leetcode.dayliy;

import sun.nio.ch.DirectBuffer;

import java.nio.ByteBuffer;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * <p>
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 * <p>
 * 你允许：
 * <p>
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 示例 1: (From the famous "Die Hard" example)
 * <p>
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/water-and-jug-problem
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/6/12 19:50
 */
public class 水壶问题 {

    public static void main(String[] args) {
        System.out.println("水壶问题");

        boolean b = canMeasureWater(2, 6, 5);
        System.out.println(b);
    }

    /**
     * @description: 此方法是错误的
     * @author sunfch
     * @date 2020/6/13 08:04
     */
    public static boolean canMeasureWater(int x, int y, int z) {

        if (x == z || y == z || (x + y) == z) {
            return true;
        }
        if ((x * x + y * y) >= z * z && (x * x + z * z) >= y * y && (y * y + z * z) >= x * x) {
            return true;
        }
        return false;
    }

    public static boolean canMeasureWater2(int x, int y, int z) {
        return false;
    }

}
