package inspur.JVMTst;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/6/30 14:09
 */
public class Test0630 {

    public static void main(String[] args) {


        List<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        arr1.add(4);

        List<Integer> arr2 = new ArrayList<>();
        arr2.add(5);
        arr2.add(6);
        arr2.add(7);
        arr2.add(8);

        List<List<Integer>> list = new ArrayList<>();
        list.add(arr1);
        list.add(arr2);

        List<Integer> result = arrMerge(list);
        System.out.println("输出结果是====" + result.toString());
    }

    /**
     * @description: 实现数组合并
     * @author sunfch
     * @date 2020/6/30 14:11
     */
    public static List<Integer> arrMerge(List<List<Integer>> list) {

        // 定义一个输出数组;
        ArrayList<Integer> result = new ArrayList<>();

        //数组长度不一致; 获得最长的数组的长度
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(list.get(i).size(), max);
        }

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < list.size(); j++) {
                //判断当前对象的数组length大于i
                if (list.get(j).size() > i) {
                    result.add(list.get(j).get(i));
                }
            }
        }
        return result;
    }
}

class Test222 {

    public static void main(String[] args) {
        long value = 2 <<50 ;
        System.out.println(value);
    }
}