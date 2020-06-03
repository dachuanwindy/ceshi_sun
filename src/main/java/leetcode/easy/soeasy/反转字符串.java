package leetcode.easy.soeasy;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 根据指定K 反转字符串
 * @date 2020/5/29 23:43
 */
public class 反转字符串 {

    public static void main(String[] args) {
        System.out.println("根据K 反转字符串");
        String s = method2("112222333", 3);
        System.out.println(s);
    }

    public static String method2(String str, int k) {
        if (str.length() <= k) {
            return str;
        }
        return str.substring(k + 1, str.length()) + str.substring(0, k);
    }

}
