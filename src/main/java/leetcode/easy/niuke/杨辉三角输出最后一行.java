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

        List<Integer> integers = yangHui(4);
        System.out.println(integers.toString());
    }

    /**
     * description: 循环打印杨辉三角
     *
     * @param index
     * @return java.util.List<java.lang.Integer>
     */
    public static List<Integer> yangHui(int index) {


        List<List<Integer>> YH = new ArrayList<>();

        if (index == 1) {
            YH.add(new ArrayList<Integer>());
            YH.get(0).add(1);
            return YH.get(0);
        }

        YH.add(new ArrayList<Integer>());
        YH.get(0).add(1);

        for (int i = 0; i < index; i++) {
            ArrayList<Integer> sub = new ArrayList<>();
            List<Integer> pre = YH.get(i);
            sub.add(1);
            for (int j = 0; j < i; j++) {
                sub.add(pre.get(i) + pre.get(i));
            }
            sub.add(1);
            YH.add(sub);
        }
        return YH.get(index);
    }


    //再次实现
    public static List<Integer> YangHui(int n) {

        List<List<Integer>> YH = new ArrayList<>();

        if (n == 1) {
            YH.add(new ArrayList<>());
            YH.get(0).add(1);
            return YH.get(0);
        }

        for (int i = 0; i < n; i++) {

            for (int j = 2; j <= i; j++) {

            }
        }

        return null;
    }

    
}
