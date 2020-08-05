package leetcode.mid;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 238. 除自身以外数组的乘积
 * @date 2020/8/2 12:03
 */
public class 除自身以外数组的乘积 {

    public static void main(String[] args) {
        System.out.println("238. 除自身以外数组的乘积");

        int[] arr = {1, 2, 3, 4};
        int[] method = method(arr);
        System.out.println(method.toString());
    }


    /**
     * @description: 第一种方式采用暴力
     * @author sunfch
     * @date 2020/8/2 12:04
     */
    public static int[] method(int[] arr) {

        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int temp = 1;
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    continue;
                }
                temp = temp * arr[j];
            }
            result[i] = temp;
        }
        return result;

    }
}
