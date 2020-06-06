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

        Node node1 = reversN(node, 3);
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
}

