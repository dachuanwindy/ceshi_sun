package leetcode.专项.动态规划;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/7/10 09:24
 */
public class 最佳股票买卖时机冷冻期 {

    public static void main(String[] args) {
        System.out.println("买卖股票最佳时机");

        int[] arr = {1, 2, 3, 0, 2};
        int method = method(arr);
        System.out.println(method);


        //一次买卖股票,找出最大利润;
        int[] array = {7, 1, 5, 3, 6, 4};
        int i = method2(array);
        System.out.println(i);
    }

    /**
     * @description: 有等冻期, 还是那句话,这次操作与上次操作有关系,只能把上次的状态记录下来
     * @author sunfch
     * @date 2020/7/10 09:25
     */
    public static int method(int[] arr) {

//        定义状态转移方程:
        int[][] dp = new int[arr.length][3];
        //手上持股的,最大收益
        dp[0][0] = -arr[0];
        // 手上没有持股,在冷冻期的最大收益; --->此时已经卖掉,所有才有冷冻期
        dp[0][1] = 0;
        //手没有持股,没有冷冻期的最大收益;==> 就是 手上的已经抛空了.
        dp[0][2] = 0;

        for (int i = 1; i < arr.length; i++) {
            //手上持股:之前的股票在手, 或者 不在冷冻期买股
            dp[i][0] = Math.max(dp[i][0], dp[i - 1][2] - arr[i]);
            //手上没有股票,在冷冻期:---->把手里的股票卖掉
            dp[i][1] = dp[i - 1][0] + arr[i];
            // 手上没有股票,也不在冷冻期--->
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[arr.length - 1][2], dp[arr.length - 1][1]);
    }


    /**
     * @description: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 注意：你不能在买入股票前卖出股票。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @author sunfch
     * @date 2020/7/10 09:42
     */
    /**
     * @description: 买卖股票最佳时机---->简单题
     * @author sunfch
     * @date 2020/7/10 09:42
     */
    public static int method2(int[] arr) {
        int dp[] = new int[arr.length];
        dp[0] = 0;
        int maxProfit = 0;
        int minPrice = 100;
        for (int i = 0; i < arr.length; i++) {
            minPrice = Math.min(minPrice, arr[i]);
            dp[i] = arr[i] - minPrice;
            maxProfit = Math.max(dp[i], maxProfit);
        }


        return maxProfit;
    }
}
