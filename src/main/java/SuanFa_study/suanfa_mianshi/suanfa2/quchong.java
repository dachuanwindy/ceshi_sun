package SuanFa_study.suanfa_mianshi.suanfa2;


import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 整数去重问题, 字符串去重问题，字符串出现重复的个数
 * @Author: sunfch
 * @Date: 2019/3/2-17:11
 * @Param:
 * @Return:
 */
public class quchong {

    public static void main(String[] args) {


        int[] a = {1, 3, 5, 6, 7, -8, -9, -45, -22};
        setParted(a);
    }

    /**
     * @Description: 统计个数
     * @Author: sunfch
     * @Date: 2019/3/2-18:00
     * @Param:
     * @Return:
     */
    public static void tongji(String aa) {

        char[] chars = aa.toCharArray();
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i] + "")) {
                int count = map.get(chars[i] + "");
                map.put(chars[i] + "", count++);
            } else {
                map.put(chars[i] + "", 1);
            }
        }

        System.out.println(map.toString());
    }


    /**
     * @Description: 最大数放在左边，最小数放在右边，保持相对位置不变
     * @Author: sunfch
     * @Date: 2019/3/2-18:00
     * @Param:
     * @Return:
     */

    public static void setParted(int[] a) {
        int temp = 0;
        int border = -1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                temp = a[i];
                a[i] = a[border + 1];
                a[border + 1] = temp;
                border++;
            }
        }
        for (int j = 0; j < a.length; j++) {
            System.out.println(a[j]);
        }
    }
}


/**
 * @Description: 方程式 公鸡 母鸡 小鸡
 * @Author: sunfch
 * @Date: 2019/3/2-20:12
 * @Param:
 * @Return:
 */
class Bychicken {

    public static void main(String[] args) {
        int a, b, c;
        for (a = 0; a < 20; a++) {
            for (b = 0; b < 33; b++) {
                for (c = 0; c < 100; c++) {
                    if (5 * a + b * 3 + (1 / 3) * 100 == 100 && (a + b + c) == 100) {
                        System.out.println("公鸡" + a + "母鸡==" + b + "小计" + c);
                    }
                }

            }
        }
    }
}

/**
 * @Description: 查找字符只出现一次的第一个字符
 * @Author: sunfch
 * @Date: 2019/3/2-20:12
 * @Param:
 * @Return:
 */
class ceshi1 {


    public static void main(String[] args) {

        method("123");

    }


    public static void method(String str) {

        byte[] bytes = str.getBytes();
        int we[] = {0};

        for (int i = 0; i < bytes.length; i++) {
            ++we[bytes[i]];
        }

        //判断数组中的个数是否==1，若==1 则是出现一次
        for (int i = 0; i < bytes.length; i++) {
            if (we[bytes[i]] == 1) {

            }
        }

    }
}


/**
 * @Description: 找到第一个出现次数最多的字符，并输出其位置；
 * @Author: sunfch
 * @Date: 2019/3/2-21:01
 * @Param:
 * @Return:
 */
class ceshi3 {
    public static void main(String[] args) {
        findmaxcharIndex("123456");
    }


    /**
     * @Description: 找到出现次数最多，然后是
     * @Author: sunfch
     * @Date: 2019/3/2-21:08
     * @Param:
     * @Return:
     */
    public static void findmaxcharIndex(String chars) {
        byte[] bytes = chars.getBytes();

        int[] a = {0};
        for (int i = 0; i < bytes.length; i++) {
            ++a[bytes[i]];
        }
        int count = 0;
        int index = 0;
        for (int i = 0; i < bytes.length; i++) {

            if (a[bytes[i]] > count) {
                count = a[bytes[i]];
                index = i;
            }
        }
    }
}

/**
 * @Description: 两个大数相加
 * @Author: sunfch
 * @Date: 2019/3/2-21:28
 * @Param:
 * @Return:
 */

class BigNumAdd{
    public static void main(String[] args) {

    }
    public static String  bignumAdd(String numa, String numb){

        char[] chars = numa.toCharArray();
        return ";";
    }
}