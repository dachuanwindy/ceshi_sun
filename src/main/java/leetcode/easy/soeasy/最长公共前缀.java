package leetcode.easy.soeasy;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 最长公共前缀问题:
 * ["flower","flow","flight"]
 * 输出: "fl"
 * @date 2020/6/3 20:51
 */
public class 最长公共前缀 {

    public static void main(String[] args) {
//        String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"c", "c"};

        String method = method(strs);
        System.out.println(method);
    }

    public static String method(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (c != (strs[j].charAt(i))) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return "";
    }
}
