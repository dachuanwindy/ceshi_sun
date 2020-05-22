package leetcode.easy.niuke;

import lombok.Data;
import sun.jvm.hotspot.jdi.VoidValueImpl;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 两个链表相加, 注意进位
 * @date 2020/5/22 14:07
 */
public class 链表相加 {

    public static void main(String[] args) throws Exception {
        System.out.println("===两个链表相加===");

        Node l1 = new Node(5);
        l1.next=new Node(1);
        Node l2 = new Node(7);

        Node add = add(l1, l2);
    }

    public static Node add(Node l1, Node l2) throws Exception {
        Node result = new Node(0);
        int t = 0;
        while (l1 != null || l2 != null || t != 0) {
            if (l1 != null) {
                t = t + l1.value;
                l1 = l1.next;
            }
            if (l2 != null) {
                t = t + l2.value;
                l2 = l2.next;
            }
            Node node = new Node(t % 10);
            node.next = result;
            result = node;
            t /= 10;

        }
        return result;
    }
}

@Data
class Node {
    int value;
    Node next;

    Node(int value) throws Exception {
        if(value>9){

        throw  new  Exception("不能大于9 ");
        }
        this.value = value;
    }
}