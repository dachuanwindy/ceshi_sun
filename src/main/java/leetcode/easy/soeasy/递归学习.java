package leetcode.easy.soeasy;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 递归分三步走:
 * 1.找终止条件;
 * 2.找返回值;
 *
 * @date 2020/6/2 07:48
 */
public class 递归学习 {
    public static void main(String[] args) {

        int add = add(3);
        System.out.println(add);
    }
    // 相加递归,
    public static int add(int n) {
        if (n == 1) {
            return n;
        }
        return n + add(n - 1);
    }
}
