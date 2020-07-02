package leetcode.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunfch
 * @version V1.0  这里整理链表的基本操作题.做一个梳理
 * @Description: 109题
 * @date 2020/7/1 13:47
 */
public class 有序链表生成二叉搜索树 {
    public static void main(String[] args) {
        System.out.println("有序链表生成二叉搜索树");
        // convertToTree();
        //第二个调试
        Node node = new Node(3);
        node.next = new Node(5);
        node.next.next = new Node(1);
        node.next.next.next = new Node(2);
        node.next.next.next.next = new Node(7);
        node.next.next.next.next.next = new Node(8);

        Node fenge = fenge(node, 4);
        System.out.println("输出值=====");
    }

    private static List<Integer> list;

    public static void convertToTree() {

        list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        TreeNode convert = convert(0, list.size() - 1);
        System.out.println("树转换成功;" + convert.toString());


    }

    /**
     * @description: 将有序数组转换成二叉搜索树, 或者将有序链表转换成二叉搜索树;
     * @author sunfch
     * @date 2020/7/1 22:21
     */
    public static TreeNode convert(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode treeNode = new TreeNode(list.get(mid));
        if (left == right) {
            return treeNode;
        }
        treeNode.left = convert(left, mid - 1);
        treeNode.right = convert(mid + 1, right);
        return treeNode;
    }


    /**
     * @description: 链表的左右分开, 保证相对位置不变  86
     *
     * 功能已经实现:
     * @author sunfch
     * @date 2020/7/1 22:22
     */
    public static Node fenge(Node head, int k) {
        // 为空判断,这个
        if (head == null || head.next == null) {
            return head;
        }

        Node rightNode = new Node(-1);
        Node rightHead = rightNode;

        Node leftNode = new Node(-1);
        Node newHead = leftNode;

        while (head != null) {
            //小于这个值就继续迭代
            if (head.value < k) {
                //左链表中
                leftNode.next = head;
                leftNode = leftNode.next;
                head = head.next;
            } else {
                // 大于K时候,就插入到另一个链表中
                rightNode.next = head;
                rightNode = rightNode.next;
                head = head.next;
            }
        }
        leftNode.next = rightHead.next;
        return newHead.next;
    }

    //

}
