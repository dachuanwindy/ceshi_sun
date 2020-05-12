package SuanFa_study.suanfa_mianshi.suanfa2;


import ch.qos.logback.core.encoder.EchoEncoder;
import org.elasticsearch.ingest.ValueSource;
import org.elasticsearch.monitor.os.OsStats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Description: 正整数组合，找出最大的数,数据组合出最大数，最小数问题
 * @Author: sunfch
 * @Date: 2019/3/2-16:47
 * @Param:
 * @Return:
 */
public class Suanfa2 {

    public static void main(String[] args) {

        int[] arr = {11, 33, 55};
        System.out.println(Maxvalue(arr).toString());
    }

    public static StringBuffer Maxvalue(int[] arr) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arrayList.add(arr[i]);
        }
        /** 这个自定义比较器，将最大数放在最上面*/
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //这个地方是比较的核心内容，两个字符串比较，
                return (o2 + "" + o1).compareTo(o1 + "" + o2);
            }
        });

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayList.size(); i++) {
            stringBuffer.append(arrayList.get(i));
        }
        return stringBuffer;
    }
}

/**
 * @Description: 无序数组找中位数：思想：先快拍一次，
 * @Author: sunfch
 * @Date: 2019/3/3-18:01
 * @Param:
 * @Return:
 */
class FindMidNum {

    public int sort(int[] a, int start, int end) {
        int l = start;
        int r = end;
        int key = a[end];

        while (l < r) {
            while (l < r && a[l] <= key) {
                l++;
            }
            while (l < r && a[r] >= key) {
                r--;
            }
            if (l < r) {

                int temp = a[l];
                a[l] = a[r];
                a[r] = temp;

            }
        }
        return l;
    }


    /**
     * @Description: 找中位数，中心思想是：先排一下，然后找个，快排第一步，加上逻辑判断
     * @Author: sunfch
     * @Date: 2019/3/3-18:32
     * @Param:
     * @Return:
     */
    public int findMid(int a[]) {
        int start = 0;
        int end = a.length - 1;
        int mid = (a.length - 1) / 2;

        int div = sort(a, start, end);

        while (mid != div) {
            if (mid < div) {
                if (mid < div) {
                    div = sort(a, start, div - 1);
                } else {
                    div = sort(a, div + 1, end);
                }

            }
        }

        return div;
    }


}
