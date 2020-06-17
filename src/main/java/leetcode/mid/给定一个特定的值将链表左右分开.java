package leetcode.mid;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 给定一个值, 将链表左右分开, 且相对位置保证不变
 * <p>
 * <p>
 * 利用双指针去做这个题
 * @date 2020/6/4 08:27
 */
public class 给定一个特定的值将链表左右分开 {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(10);
        listNode.next.next = new ListNode(11);
        listNode.next.next.next = new ListNode(12);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(6);

        ListNode partition = partition(listNode, 7);

        System.out.println("partion=="+partition);


    }

    public static ListNode partition(ListNode head, int x) {

        ListNode before_head = new ListNode(0);
        ListNode before = before_head;

        ListNode after_head = new ListNode(0);

        ListNode after = after_head;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null;
        before.next = after_head.next;

        return before_head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
