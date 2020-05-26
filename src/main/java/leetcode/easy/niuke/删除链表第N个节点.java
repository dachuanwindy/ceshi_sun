package leetcode.easy.niuke;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 删除链表第N个节点
 * @date 2020/5/26 00:13
 */
public class 删除链表第N个节点 {

    public static void main(String[] args) {
        System.out.println("删除链表第N个节点");
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(4);
        node.next.next.next = new Node(5);


        //删除倒数第3个节点,删除的是2;
        Node method = method(node, 3);
        System.out.println(method);
    }

    public static Node method(Node l1, int n) {

        Node first = l1;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        Node second = l1;
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return second;


    }
}
