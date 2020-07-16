package leetcode.专项.回文;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/7/10 10:51
 */
public class 回文个数 {

    public static void main(String[] args) {

    }

    /**
     * @description: 回文个数, abc 算三个回文
     * @author sunfch
     * @date 2020/7/10 10:54
     */
    public static int method2(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        // 对每个可能的回文中心进行循环
        for (int i = 0; i < chars.length * 2 - 1; i++) {
            int left = i / 2;
            // 当中心是两个字母的间歇时i%2 = 1；当中心是字母时 left==right都落在该字母的位置
            int right = left + i % 2;
            while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
                left--;
                right++;
                result++;
            }
        }
        return result;
    }

}
