package leetcode.mid;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * @date 2020/6/4 13:48
 */
public class 反转链表II {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(4);
        node.next.next.next = new Node(5);
        node.next.next.next.next = new Node(7);
        node.next.next.next.next.next = new Node(9);
        node.next.next.next.next.next.next = new Node(10);

        Node node1 = reverseBetween(node, 2, 4);
        System.out.println(node1);
    }

    public static Node reverseBetween(Node head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    // 4,5,7,9
    static Node successor = null;

    public static Node reverseN(Node head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        Node last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
