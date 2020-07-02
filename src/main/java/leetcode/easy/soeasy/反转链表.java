package leetcode.easy.soeasy;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 面试简单题
 * @date 2020/6/29 23:04
 */
public class 反转链表 {


    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        node.next = new ListNode(6);
        node.next.next = new ListNode(7);
        node.next.next.next = new ListNode(10);
        ListNode node1 = reverseList(node);
        System.out.println(node1);

    }

    /**
     * @description: 反转链表--单链表递归实现
     * @author sunfch
     * @date 2020/6/30 07:19
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 递归底层来分析,新头结点,是反转后的头结点, 先不要管里面的节点是什么;
        ListNode newHead = reverseList(head.next);
        //原来头节点的下一个节点是 第二个, 第二个的下一个节点已经变成null了,现在要赋值为head;
        head.next.next = head;
        //反转之后的头结点的head.next 本该就是为空
        head.next = null;
        return newHead;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
