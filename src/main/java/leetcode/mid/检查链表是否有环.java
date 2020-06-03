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
          node.next.next.next.next = node;
        boolean method = method(node);
        System.out.println(method);
    }

    public static boolean method(Node l1) {

        if (l1 == null || l1.next == null) {
            return false;
        }
        Node now = l1;
        Node fast = null;
        Node slow = fast = l1;
        while (fast != null || fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow.value == fast.value) {
                System.out.println("循环了...");
                return true;
            }
            System.out.println("没有环状=");
        }
        return false;
    }
}

class Node {
    int value;
    Node next = null;

    Node(int value) {
        this.value = value;
    }
}