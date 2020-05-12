package SuanFa_study.SJJG_study.Linked.LinkedListReverse;

import java.util.Stack;

public class LinkedList {
}

class StackPrintLinkedList {
    public static void main(String args[]) {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode node4 = new ListNode();
        ListNode node5 = new ListNode();
        node1.data = 1;
        node2.data = 2;
        node3.data = 3;
        node4.data = 44;
        node5.data = 55;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        /**基于堆栈实现链表反转*/
        printListReverse(node1);


        /**通过递归实现反转输出，这样保证 原链表没有变化*/
        printListBydigui(node1);


    }


    /**
     * @Description: 链表输出 ，用堆栈去做，这样能保证原链表的数据不变
     * @Author: sunfch
     * @Date: 2019/3/3-23:13
     * @Param:
     * @Return:
     */
    public static void printListReverse(ListNode headNode) {
        Stack<ListNode> stack = new Stack<ListNode>();
        while (headNode != null) {
            stack.push(headNode);
            headNode = headNode.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().data);
        }
    }

    /**
     * @Description: 通过递归实现链表输出
     * @Author: sunfch
     * @Date: 2019/3/3-23:15
     * @Param:
     * @Return:
     */
    public static void printListBydigui(ListNode node) {

        if (node != null) {
            printListBydigui(node.next);
            System.out.println("==>" + node.data);
        }
    }


    public static void reverse(ListNode node) {
        ListNode pre = null;
        ListNode now = node;
        while (now != null) {
            ListNode next = now.next;
            next.next = pre;
            pre = now;
            now = next;
        }

    }

}

/**
 * Nodes模型
 */
class ListNode {
    public ListNode next;
    public int data;
}
