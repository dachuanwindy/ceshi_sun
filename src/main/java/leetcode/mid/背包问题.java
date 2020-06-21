package leetcode.mid;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 书包里装下价值最多的东西
 * @date 2020/6/8 07:56
 */
public class 背包问题 {

    public static void main(String[] args) {
        System.out.println("====");



    }

    /**
     * @description: 动态规划;
     * @author sunfch
     * @date 2020/6/8 08:01
     */
    public static int method(int[] weight, int[] val) {

        int[][] dp = new int[weight.length + 1][val.length + 1];

        //第一个元素是重量,
        dp[0][0] = 0;
        for (int i = 0; i <= weight.length; i++) {
            for (int j = 0; j <= val.length; j++) {
                if(j-weight[i]<0){
                dp[i][j]= dp[i-1][j];
                }
            }
        }
        return dp[weight.length][val.length];
    }
}
