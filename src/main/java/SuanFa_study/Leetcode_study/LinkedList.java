package SuanFa_study.Leetcode_study;

public class LinkedList {
}


/**
 * @Description: 删除排序数组中的重复元素
 * @Author: sunfch
 * @Date: 2019/3/3-21:07
 * @Param:
 * @Return: 给定一个排序的数组，将数组中的重复元素去掉，相同的只保留一个，
 * 并且返回数组新的元素个数，不要创建一个新的数组来保存结果。在常量时间内解决这个问题
 */

class DeleteElement {


    public static void method(int a[]) {

        if (a.length == 0) {
            return;
        }

        int index = 0;
        int next = 1;

        while (next < a.length) {

            while (next < a.length && a[index] == a[next]) {
                next++;
            }
            if (next < a.length) {
                index++;
                a[index] = a[next];
                next++;
            }
        }

        System.out.println(a.toString());
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }


    public static void main(String[] args) {
        int a[] = {1, 3, 5, 7, 8, 9, 9, 10};

        method(a);
    }

}


/**
 * 单链表，实现排序，反向输出
 */
class LinkedListResvers {





    //------------------链表基本操作--------------------

    LinkedNode head;

    LinkedNode end;

    public LinkedListResvers() {
        head = null;
        end = null;
    }

    /**
     * @Description: 单链表添加数据: 生成的新节点的下一个节点等于head, 然后head 等于新节点node
     * @Author: sunfch
     * @Date: 2019/3/3-22:46
     * @Param:
     * @Return:
     */

    public void addNodes(int value) {
        LinkedNode linkedNode = new LinkedNode(value);

        linkedNode.next = head;
        head = linkedNode;

    }

    public void reverse(){}


    public static void main(String[] args) {
        LinkedListResvers linkedlist = new LinkedListResvers();
        linkedlist.addNodes(1);
        linkedlist.addNodes(2);
        linkedlist.addNodes(3);
        linkedlist.addNodes(5);




    }


}

class LinkedNode {
    int value;
    LinkedNode next;

    LinkedNode(int value) {
        this.value = value;
    }
}