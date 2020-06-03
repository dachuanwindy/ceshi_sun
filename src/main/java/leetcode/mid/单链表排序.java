package leetcode.mid;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 自己实现 sunfch
 * @date 2020/6/2 15:32
 */
public class 单链表排序 {
    public static void main(String[] args) {
        Node node = new Node(4);
        node.next = new Node(3);
        node.next.next = new Node(2);
        Node method = sort(node);
        System.out.println(method);
    }

    static Node sort(Node head) {
        // 若只有一个节点就直接返回了
        if (head.next == null || head == null) {
            return head;
        }
        Node fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
        }
        Node temp = slow.next;
        slow.next = null;
        Node left = sort(head);
        Node right = sort(temp);
        Node h = new Node(0);
        Node res = h;
        while (left != null && right != null) {
            if (left.value < right.value) {
                h.next = left;
                left = left.next;

            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;

    }
}

