package leetcode.dayliy;

import java.math.BigDecimal;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 这个通过bigdecimal 能完成这个工作,但是代码中不支持;
 * @date 2020/6/14 08:51
 */
public class 结尾中有0的个数 {

    public static void main(String[] args) {
        int i = trailingZeroes(30);
    }

    public static int trailingZeroes(int n) {


        BigDecimal value = new BigDecimal(1);
        for (int i = n; i > 1; i--) {
            value = value.multiply(new BigDecimal(i));
        }
        //第二步: 分析这个值结尾的0;
        int k = 0;
        BigDecimal divisor = new BigDecimal(10);
        BigDecimal[] bigDecimals = value.divideAndRemainder(divisor);
        while (bigDecimals[1].equals(new BigDecimal(0))) {
            k = k + 1;
            bigDecimals = bigDecimals[0].divideAndRemainder(divisor);
        }
        System.out.println(k);
        return k;
    }

}
