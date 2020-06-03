package leetcode.easy.经典面试题;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 反转一个链表中的k个元素
 * @date 2020/5/26 09:06
 */
public class 反转K个链表 {
    public static void main(String[] args) {
        System.out.println("实现链表中k个元素反转");

        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
      //  Node nodeTest = reverse(node);
      //  System.out.println(nodeTest);

        Node method = method(node, 4);
        System.out.println(method);

    }

    /**
     * description: 实现链表中k个元素反转: 遍历实现
     *
     * @param l1
     * @return leetcode.easy.经典面试题.Node
     */

    public static Node method(Node l1, int k) {
        // 若小于等于1 输出原链表
        Node temp = l1;
        for (int i = 0; i < k && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            return l1;
        }

        Node t2 = temp.next;
        temp.next = null;

        Node newHead = reverse(l1);
        Node newtemp = method(t2, k);
        l1.next = newtemp;
        return newHead;


    }

    //递归实现链表反转
    static Node reverse(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node reverse = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return reverse;

    }
}
