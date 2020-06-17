package leetcode.mid;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 这个是经典问:  70题
 * <p>
 * 1,可以用递归
 * 2  动态规划
 * @date 2020/6/16 15:58
 */
public class 爬楼梯 {

    public static void main(String[] args) {
        System.out.println("爬楼梯解决方案====");
        int method = method(4);
        System.out.println(method);
    }

    /**
     * @description: 采用了动态规划的方式实现的.
     * <p>
     * 第一步:base
     * 第二步:状态转移方程;
     * @author sunfch
     * @date 2020/6/16 16:46
     */
    public static int method(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        //1 第一步:初始化动态规划数组, 根据情况,可能是一维数组,有可能是二维数组
        int[] dp = new int[n + 1];

        //2 第二步:初始值判定
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            // 第三步:状态转移,这个是核心
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    /**
     * @description: 递归的方式, 在leetcode上超时,
     * <p>
     * 将中间状态进行保存, 这就是动态规划
     * @author sunfch
     * @date 2020/6/16 16:54
     */
    public static int method3(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int max = method3(n - 1) + method3(n - 2);
        return max;
    }


}
