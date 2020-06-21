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

        double v1 = method3(5);
        System.out.println(v1);


        double v = method2(5);
        System.out.println(v);
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


    /**
     * @description: 平方根问题, 这个采用二分法进行
     * @author sunfch
     * @date 2020/6/17 08:32
     */
    public static double method2(int x) {

        double left = 0, right = x;

        while (left < right) {
            double mid = left + (right - left) / 2;
            if (Math.abs(x - mid * mid) < 0.0000000005F) {
                return mid;
            }
        }
        return 0.000001F;
    }

    public static double method3(float c) {
        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c / t) > err * t) {
            t = (c / t + t) / 2.0;
        }
        return t;
    }

}