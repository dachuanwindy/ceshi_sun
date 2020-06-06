package leetcode.mid;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 输出给定值的平房根, 整数,小数部分舍去
 * @date 2020/6/3 11:12
 */
public class 平方根 {
    public static void main(String[] args) {

        int sqr = sqr(19);
        System.out.println(sqr);
    }

    public static int sqr(int x) {

        if (x <= 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        for (int i = 1; i <= x; ++i) {
            int result = i * i;

            if ((result - x) == 0) {
                return i;
            }
            if ((result - x) > 0) {
                return i - 1;
            }
        }
        return -1;
    }
}