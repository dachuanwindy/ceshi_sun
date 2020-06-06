package leetcode.mid;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 检查链表是否有环, 条件:快慢指针;
 * @date 2020/6/2 08:20
 */
public class 检查链表是否有环 {

    public static void main(String[] args) {

        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next = new Node(9);
        node.next.next.next.next.next.next.next = node.next;
        Node method = method(node);
        System.out.println(method.value);
    }

    static int id = 1;

    public static Node method(Node l1) {

        if (l1 == null || l1.next == null) {
            return l1;
        }
        Node now = l1;
        Node slow = l1, fast = l1;
        while (fast != null || fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //相等是在某个地方相遇了,下次再相遇,就是环的长度了;
            while (fast == slow) {
                int len = 1;
                fast = fast.next.next;
                slow = slow.next;
                while (fast != slow) {
                    len++;
                    fast = fast.next.next;
                    slow = slow.next;
                }
                System.out.println("The length of circle is:" + len);
                //输出环入口节点
                //相等之后,fast
                fast = l1;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                    id++;
                }
                return slow;
            }
        }
        return l1;
    }

    //自己再实现链表环判断及

}

class Node {
    int value;
    Node next = null;

    Node(int value) {
        this.value = value;
    }
}