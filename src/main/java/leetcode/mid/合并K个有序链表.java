package leetcode.mid;

import java.util.List;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 23题
 * @date 2020/7/2 07:01
 */
public class 合并K个有序链表 {


    public static void main(String[] args) {

    }

    /**
     * @description: 实现方式: 首先将合并两个链表
     * @author sunfch
     * @date 2020/7/2 07:02
     */
    public ListNode mergeList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeList(l1.next, l2);
            return l1;
        }
        l2.next = mergeList(l1, l2.next);
        return l2.next;
    }


    /**
     * @description: 合并两个链表, 通过迭代方式
     * @author sunfch
     * @date 2020/7/2 08:54
     */

    public ListNode mergeList2(ListNode l1, ListNode l2) {
        ListNode tempNode = new ListNode(0);
        ListNode tail = tempNode;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
            } else {
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            }
        }
        tail.next = l1 != null ? l1 : l2;
        return tempNode.next;
    }


    /**
     * @description: 实现多个链表合并
     * @author sunfch
     * @date 2020/7/2 08:59
     */
    public ListNode MergeListK(List<ListNode> list, int left, int right) {
        if (left == right) {
            return list.get(left);
        }
        int mid = (left + right) / 2;
        ListNode l1 = MergeListK(list, left, mid);
        ListNode l2 = MergeListK(list, mid + 1, right);
        return mergeList2(l1, l2);
    }
}
