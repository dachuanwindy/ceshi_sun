package leetcode.easy.niuke;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 检查字符串输入的是否正确
 * @date 2020/3/22 09:12
 */
public class CheckWord {

    public static void main(String[] args) {
        String s = checkWords("112233");
        System.out.println(s);


    }

    public static String checkWords(String sourWord) {

        char[] chars = sourWord.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (sb.length() < 2) {
                sb.append(chars[i]);

            }
            if (sb.length() >= 2) {
                if (sb.charAt(sb.length() - 1) == chars[i] && sb.charAt(sb.length() - 2) == chars[i]) {
                    continue;
                }
            }
            if (sb.length() >= 3) {
                if (sb.charAt(sb.length() - 1) == chars[i] && sb.charAt(sb.length() - 2) == sb.charAt(sb.length() - 3)) {
                    continue;
                }
            }
            sb.append(chars[i]);

        }

        return sb.toString();
    }
}
