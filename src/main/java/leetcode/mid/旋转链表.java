package leetcode.mid;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 61 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2020/7/1 23:05
 */
public class 旋转链表 {


    public static void main(String[] args) {
        System.out.println("旋转链表");
    }

    /**
     * @description: 旋转链表, 实现思想,先判断在哪个位置断开连接,
     * 先让链表成为一个环  思路正确 ,过!!!
     * @author sunfch
     * @date 2020/7/1 23:09
     */
    public static ListNode rotateRight(ListNode head, int k) {

        int total = 1;
        ListNode oldHead = head;
        while (head.next != null) {
            head = head.next;
            total++;
        }
        //形成一个环状链表
        head.next = oldHead;
        int newKey = k % total;
        for (int i = 0; i < newKey; i++) {
            oldHead = oldHead.next;
        }
        ListNode newHead = oldHead.next;
        oldHead.next = null;
        return newHead;
    }
}
