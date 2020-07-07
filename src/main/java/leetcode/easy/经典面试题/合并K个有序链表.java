package leetcode.easy.经典面试题;


import java.util.List;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 头条面试题, 合并K个有序链表
 * <p> 就是这么实现的
 * @date 2020/6/4 22:17
 */
public class 合并K个有序链表 {
    public static void main(String[] args) {

    }

    /**
     * @description: 合并K个有序链表
     * @author sunfch
     * @date 2020/7/7 18:22
     */
    public static ListNode mergeK(List<ListNode> listNodes, int left, int right) {

        if (left == right) {
            return null;
        }
        ListNode newNode = new ListNode(0);
        ListNode temp = newNode;
        ListNode newNode2 = new ListNode(0);
        ListNode temp2 = newNode2;

        int mid = (left + right) / 2;
        temp = mergeK(listNodes, left, mid);
        temp2 = mergeK(listNodes, mid + 1, right);
        return merge2(temp, temp2);
    }

    /**
     * @description: 合并两个链表, 为上边提供
     * @author sunfch
     * @date 2020/7/7 18:28
     */
    public static ListNode merge2(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(0);
        ListNode temp = newNode;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                temp = l1;
                l1 = l1.next;
            } else {
                temp = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return newNode.next;
    }
}

class ListNode {

    ListNode next;
    int val;

    ListNode(int value) {
        this.val = value;
    }

}
