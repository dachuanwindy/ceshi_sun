package leetcode.mid;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 头条面试题
 * <p>
 * 股票利益最大化,可以问那天交易,  也可以问最大的值
 * 暴力解决方案
 * @date 2020/6/22 11:58
 */
public class 股票利益最大 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 5};
        int[] ints = maxProfit(arr);
        System.out.println(ints);

        int i = maxProfit2(arr);
        System.out.println(i);


        //暴力解决方案
        int i1 = maxprofit3(arr);
        System.out.println("======>" + i1);
    }

    /**
     * @description: 哪天买, 哪天卖收益最大
     * @author sunfch
     * @date 2020/6/22 12:14
     */
    public static int[] maxProfit(int[] prices) {

        int cost = 555;
        int profit = 0;
        int minday = 0;
        int buyDay = -1;
        int sailDay = -1;
        for (int i = 0; i < prices.length; i++) {
            if (cost > prices[i]) {
                minday = i;
                cost = prices[i];
            }
            if (prices[i] - cost > profit) {
                buyDay = minday;
                sailDay = i;
                profit = prices[i] - cost;
            }
        }
        int[] ints = {buyDay, sailDay};
        return ints;
    }

    /**
     * @description: 输出最大利润
     * @author sunfch
     * @date 2020/6/22 14:42
     */
    public static int maxProfit2(int[] price) {

        int max = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < price.length; i++) {
            min = Math.min(min, price[i]);
            if (price[i] - min > max) {
                max = Math.max(max, price[i] - min);
            }
        }
        return max;
    }

    public static int maxprofit3(int[] prices) {


        int buyDay = 0, sealDay = 0;
        int max = -1;
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (prices[i] - prices[j] > max) {
                    max = prices[i] - prices[j];
                    buyDay = j;
                    sealDay = i;
                }
            }
        }
        System.out.println(buyDay + "=====" + sealDay);
        return 12;

    }
}
