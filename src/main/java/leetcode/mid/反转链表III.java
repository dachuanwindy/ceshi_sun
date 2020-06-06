package leetcode.mid;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 反转链表, 每个阶段反转;
 * @date 2020/6/5 01:13
 */
public class 反转链表III {

    public static void main(String[] args) {
        System.out.println("反转链表,每个N个反转一下");

    }

    public static Node reversNodes(Node head, int n) {
        Node cur = head;
        int i = 0;
        while (cur != null) {
            cur = cur.next;
            i++;
            Node successor = null;
            if (i == n) {



            }


        }
        return   null;
    }

    public static Node revers(Node head) {
        if (head.next == null || head == null) {
            return head;
        }
        Node last = revers(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

}
