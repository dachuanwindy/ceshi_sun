package leetcode.hard;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 排序有点难----答案是正确的
 * @date 2020/6/2 22:48
 */
public class 链表排序 {

    public static void main(String[] args) {

        ListNode node = new ListNode(2);
        node.next = new ListNode(3);
        node.next.next = new ListNode(9);
        node.next.next.next = new ListNode(5);
        ListNode listNode = sortList(node);
        System.out.println(listNode);
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
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


    public static ListNode sort(ListNode node) {
        //递归调用,
        if (node == null || node.next == null) {
            return node;
        }
        // 找到中间节点;
        ListNode fast = node.next, slow = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;

        ListNode left = sort(node);
        ListNode right = sort(temp);
        ListNode h = new ListNode(0);
        ListNode res = h.next;
        while (left != null && right != null) {
            if (left.val < right.val) {
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

class ListNode {
    int val;
    ListNode next;

    ListNode(int value) {
        this.val = value;
    }
}