package leetcode.easy.经典面试题;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 基本面试题, 实现两个有序链表合并
 * @date 2020/5/23 16:31
 */
public class 合并两个有序链表 {

    public static void main(String[] args) {
        System.out.println("两个有序链表合并");
        Node node = new Node(5);
        node.next = new Node(4);
        node.next.next = new Node(3);


        Node method = method2(node, node);

        System.out.println(method.toString());
    }


    //只能从大到小排序 非递归实现
    public static Node method(Node l1, Node l2) {
        Node node = new Node(0);
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.value >= l2.value) {
                    Node node1 = new Node(l1.value);
                    node1.next = node;
                    node = node1;
                    l1 = l1.next;
                } else {
                    Node node2 = new Node(l2.value);
                    node2.next = node;
                    node = node2;
                    l2 = l2.next;
                }
            }
            if (l1 == null && l2 != null) {
                Node node2 = new Node(l2.value);
                node2.next = node;
                node = node2;
                l2 = l2.next;
            }
            if (l2 == null && l1 != null) {
                Node node1 = new Node(l1.value);
                node1.next = node;
                node = node1;
                l1 = l1.next;
            }
        }

        return node;
    }


    //递归实现
    public static Node method2(Node l1, Node l2) {

        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        Node head = null;
        if (l1.value <= l2.value) {
            head = l1;
            head.next = method2(l1.next, l2);
        } else {
            head = l2;
            head.next = method2(l1, l2.next);
        }
        return head;
    }
}
