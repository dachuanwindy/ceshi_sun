package leetcode.easy.经典面试题;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 实现链表的反转
 * @date 2020/5/24 09:27
 */
public class 链表反转 {
    public static void main(String[] args) {
        System.out.println("链表反转实现====");

        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);

        //Node node1 = reverseNode(node);

        Node node2 = reverseDigui(node);
        System.out.println(node2);
    }

    /**
     * description: 基本思路
     *
     * @param l1
     * @return leetcode.easy.经典面试题.Node
     */
    public static Node reverseNode(Node l1) {
        if (l1 == null || l1.next == null) {
            return l1;
        }

        // 1-->2-->3-->4
        Node pre = null;
        Node now = l1;
        while (now != null) {
            // next=2-->3-->4;
            Node next = now.next;
            //当前now=1 但是执行下面这行之后,now=1, now.next=null;// 这里把 now 单独拎出来了.
            now.next = pre;
            //执行这行之后,pre=1, pre.next=null;
            pre = now;
            now = next;
        }
        return pre;

    }

    public static Node reverseDigui(Node l1) {

        if (l1.next == null) {
            return l1;
        }
        Node next = l1.next;
        l1.next = null;
        Node pre = reverseDigui(next);
        next.next = l1;
        return pre;


    }
}
