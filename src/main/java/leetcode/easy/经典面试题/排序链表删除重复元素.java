package leetcode.easy.经典面试题;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 已经排好顺序的链表, 删除重复节点
 * @date 2020/5/23 19:19
 */
public class 排序链表删除重复元素 {

    public static void main(String[] args) {
        System.out.println("重复链表,删除重复节点");
        Node node = new Node(2);
        node.next= new Node(3);
        node.next.next= new Node(3);
        node.next.next.next= new Node(5);
        node.next.next.next.next= new Node(5);

        Node method = method(node);
        System.out.println(method);

    }

    //循环的方式
    public static Node method(Node node) {

        Node l1 =node;
        while (l1.next != null) {
            if (l1.value == l1.next.value) {
                l1.next = l1.next.next;
            } else {
                l1 = l1.next;
            }
        }
        return node;
    }
}
