package leetcode.mid;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 反转链表, 每个阶段反转;
 * <p>
 * 当k=2时 1,2,3,4,5---> 2,1,4,3,5
 * 当k=3   3,2,1,4,5
 * @date 2020/6/5 01:13
 * <p>
 * 转换思路:
 * <p>
 * 1-2-3-4-5-6->null
 * <p>
 * 2-1->null   3-4-5-6_null
 * new head =2;
 * <p>
 * old-head= 1;
 * old-head. next = reverseGroup(Node k)
 * 老节点的下一个节点,等于递归返回的结果.
 */
public class 反转链表III {

    public static void main(String[] args) {
        System.out.println("反转链表,每个N个反转一下");

        Node node = new Node(2);
        node.next = new Node(3);
        node.next.next = new Node(5);
        node.next.next.next = new Node(7);
        node.next.next.next.next = new Node(9);
        node.next.next.next.next.next = new Node(11);


        //Node node1 = reversGroup(node, 2);
        //System.out.println(node1);

        // 两两反转

        Node node1 = method3(node);
        System.out.println(node1);


    }

    //实现反转
    public static Node reversGroup(Node head, int n) {

        Node a, b;
        a = b = head;
        for (int i = 0; i < n; i++) {
            if (b == null) {
                return head;
            } else {
                b = b.next;
            }
        }
        Node newHead = reversBetween(a, b);
        a.next = reversGroup(b, n);
        return newHead;

    }

    //单链表,迭代反转;
    public static Node reversBetween(Node head, Node node2) {
        Node pre = null, cur, nxt;
        cur = head;
        nxt = head;
        while (cur != node2) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }


    /**
     * @description: 这个是LeetCode的题, 两个反转  z
     * 1-2-3-4-5->null 转化后 2-1-4-3-5->null;
     * <p>
     * newHead = head.next;
     * head.next = swap(head.next.next);
     * newHead.next= head;
     * return NewHead;
     * @author sunfch
     * @date 2020/6/8 11:04
     */
    public static Node method3(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = head.next;
        head.next = method3(head.next.next);
        newHead.next = head;
        return newHead;
    }

}
