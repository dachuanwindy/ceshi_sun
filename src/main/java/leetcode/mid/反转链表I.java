package leetcode.mid;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 一个链表, 反转前N个
 * @date 2020/6/5 00:33
 */
public class 反转链表I {
    public static void main(String[] args) {

        Node node = new Node(2);
        node.next = new Node(3);
        node.next.next = new Node(4);
        node.next.next.next = new Node(6);
        node.next.next.next.next = new Node(9);
        node.next.next.next.next.next = new Node(10);

        // 部分链表反转
        // Node node1 = reversN(node, 3);
        // System.out.println(node1);

        //全链表反转
        // Node node2 = reverseAll(node);
        //  System.out.println(node2);

        // 两两反转
        Node node1 = reverse2T2(node);
        System.out.println(node1);
    }

    /**
     * 连接点.保存后驱动指针
     */
    static Node successor = null;

    /**
     * 反转N个链表
     */
    public static Node reversN(Node head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        Node last = reversN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    /**
     * 反转整个链表:通过
     */

    public static Node reverseAll(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseAll(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * @description: 实现部分链表反转
     * @author sunfch
     * @date 2020/6/21 07:54
     */
    static Node temp;

    public static Node reverseN(Node head, int n) {
        if (n == 1) {
            temp = head.next;
            return head;
        }
        Node newHead = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = temp;
        return newHead;
    }

    /**
     * @description: 实现链表的两两反转
     * @author sunfch
     * @date 2020/6/21 07:55
     */
    public static Node reverse2T2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = head.next;
        Node next = reverse2T2(head.next.next);
        head.next.next = head;
        head.next = next;
        return newHead;
    }


    /**
     * @description: 单链表排序
     * @author sunfch
     * @date 2020/6/21 08:03
     */
    public static Node NodeSort(Node head) {

        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head.next;
        head.next = null;
        Node left = NodeSort(head);
        Node right = NodeSort(temp);

        Node h = new Node(0);

        Node res = h;
        while (left != null && right != null) {
            if (left.value > right.value) {
                h.next = left;
                left = left.next;
                h = h.next;
            } else {
                h.next = right;
                right = right.next;
                h = h.next;
            }
        }
        h = left == null ? right : left;
        return res;
    }

}

