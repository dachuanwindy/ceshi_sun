package leetcode.dayliy;

import java.util.LinkedList;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/6/12 19:13
 */
public class 判断一个整数是否是回文数 {

    public static void main(String[] args) {
        System.out.println("判断一个整数是否是回文数");

        isPalindrome(12345);
    }


    public static boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }
        LinkedList<Integer> list = new LinkedList();
        int temp = x;
        while (temp > 0) {
            int k = temp % 10;
            list.add(k);
            temp = (temp - k) / 10;
        }
        int data = 0;
        for (int i = 0; i < list.size(); i++) {
            data = data * 10 + list.get(i);
        }
        System.out.println(data);

        if (data == x) {
            return true;
        }
        return false;

    }
}