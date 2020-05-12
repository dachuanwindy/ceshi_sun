package SuanFa_study.suanfa_mianshi;


/**
 * @Description: 算法题，实现算法的面试
 * @Author: sunfch
 * @Date: 2019/3/2-16:08
 * @Param:
 * @Return:
 */
public class Suanfa_test {
    public static void main(String[] args) {


        String str11 = str_reverse1("12345");
        System.out.println(str11);

    }


    /**
     * @Description: 利用stringbuffer 实现排序
     * @Author: sunfch
     * @Date: 2019/3/2-16:16
     * @Param:
     * @Return:
     */
    public static StringBuilder str_reverse(String str) {
        return new StringBuilder(str).reverse();
    }

    /**
     * @Description: 利用字节实现排序
     * @Author: sunfch
     * @Date: 2019/3/2-16:16
     * @Param:
     * @Return:
     */

    public static String str_reverse1(String str) {
        char[] strBytes = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = strBytes.length - 1; i >= 0; i--) {
            stringBuffer.append(strBytes[i]);
        }
        return stringBuffer.toString();
    }




}


/**
 * @Description: Node 节点，这个 Node原型
 * @Author: sunfch
 * @Date: 2019/3/2-16:38
 * @Param:
 * @Return:
 */
class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
    }
}
//TODO----- 暂时先放放
class ListSort {
    public void addNode(int value) {

    }
}