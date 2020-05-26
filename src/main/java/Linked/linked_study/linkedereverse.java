package Linked.linked_study;

import lombok.Data;

import java.util.Stack;

/**
 * @author sunfch
 * @create 2018-12-04 11:11
 * @desc 链表反转实现
 **/
public class linkedereverse {
    public static void main(String[] args) {

        Node node = new Node(123);

        node.next = new Node(234);
        node.next.next = new Node(23456);
        node.next.next.next = new Node(789);

        LinkListPx linkListPx = new LinkListPx();
        Node node1 = linkListPx.quickSort(node, null);


        NodeReverse nodeReverse = new NodeReverse();
        // nodeReverse.LinkRevertByMe(node);

//        反转整个链表

        // Node node1 = nodeReverse.LinkRevert(node);
        //  Node node1 = nodeReverse.LinkedNodeRevert2(node);

        //通过递归调用实现的
        Node nodeByStack = nodeReverse.reverserLinkedList(node);

        System.out.println(nodeByStack);

    }
}


/**
 * @Description: 节点模型
 * @Author: sunfch
 * @Date: 2019/2/21-0:09
 * @Param:
 * @Return:
 */
@Data
class Node {
    int key;
    Node next;
    int val;

    /**
     * 初始化节点
     */
    Node(int key) {
        this.key = key;
    }

    Node() {
    }
}

class NodeReverse {


    /**
     * @description: 通过递归反向输出
     * @author sunfch
     * @date 2020/3/7 12:27
     */
    public void reverse(Node node) {
        if (node != null) {
            System.out.println(node.key);
            reverse(node.next);
        }
    }


    /**
     * @description: 链表--反转；实现链表的反转
     * @author sunfch  可行，简单优雅
     * @date 2020/3/7 13:20
     */
    public Node LinkedNodeRevert2(Node head) {

        if (head == null || head.next == null) {
            return head;
        }
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * @description: 通过递归实现 改变链表的顺序;
     * @author sunfch
     * @date 2020/3/7 14:04
     */

    public Node reverserLinkedList(Node node) {
        if (node.getNext() == null || node == null) {
            return node;
        }
        reverserLinkedList(node.getNext());
        node.getNext().setNext(node);
        node.setNext(null);
        return node;
    }


    //堆栈方式实现，就相当于构造一个新的链表
    public Node reverserLinkedList2(Node node) {
        Stack<Node> nodeStack = new Stack<>();
        Node head = null;
        //存入栈中，模拟递归开始的栈状态
        while (node != null) {
            nodeStack.push(node);
            node = node.getNext();
        }
        //特殊处理第一个栈顶元素（也就是反转前的最后一个元素，因为它位于最后，不需要反转，如果它参与下面的while， 因为它的下一个节点为空，如果getNode()， 那么为空指针异常）
        if ((!nodeStack.isEmpty())) {
            head = nodeStack.pop();
        }
        //排除以后就可以快乐的循环
        while (!nodeStack.isEmpty()) {
            Node tempNode = nodeStack.pop();
            tempNode.getNext().setNext(tempNode);
            tempNode.setNext(null);
        }
        return head;
    }

}

//单链表快速排序:
class LinkListPx {

    public Node quickSort(Node begin, Node end) {
        //判断为空，判断是不是只有一个节点
        if (begin == null || end == null || begin == end) {
            return begin;
        }
        //从第一个节点和第一个节点的后面一个几点
        Node first = begin;
        Node second = begin.next;

        int nMidValue = begin.val;
        //结束条件，second到最后了
        while (second != end.next && second != null) {
            if (second.val < nMidValue) {
                first = first.next;
                //判断一下，避免后面的数比第一个数小，不用换的局面
                if (first != second) {
                    int temp = first.val;
                    first.val = second.val;
                    second.val = temp;
                }
            }
            second = second.next;
        }
        //判断，有些情况是不用换的，提升性能
        if (begin != first) {
            int temp = begin.val;
            begin.val = first.val;
            first.val = temp;
        }
        //前部分递归
        quickSort(begin, first);
        //后部分递归
        quickSort(first.next, end);

        return first;
    }


}