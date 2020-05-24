package leetcode.easy.niuke;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 杨辉三角输出最后一行 这个用数组输出
 * @date 2020/3/29 11:47
 */
public class 杨辉三角输出最后一行 {

    public static void main(String[] args) {
        System.out.println("=======");

        List<Integer> integers = yangHui(5);
        System.out.println(integers.toString());
    }


    public static List<Integer> yangHui(int index) {

        List<List<Integer>> YH = new ArrayList<>();
        YH.add(new ArrayList<Integer>());
        YH.get(0).add(1);

        for (int i = 1; i <= index; i++) {
            ArrayList<Integer> sub = new ArrayList<>();
            List<Integer> pre = YH.get(i - 1);
            sub.add(1);
            for (int j = 1; j < i; j++) {
                sub.add(pre.get(i - 1) + pre.get(i));
            }
            sub.add(1);
            YH.add(sub);
        }
        return YH.get(index);
    }

}
