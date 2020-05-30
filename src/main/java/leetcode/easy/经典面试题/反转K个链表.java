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
    }

    /**
     * description: 实现链表中k个元素反转: 遍历实现
     *
     * @param l1
     * @return leetcode.easy.经典面试题.Node
     */

    public static Node method(Node l1, int k) {
        // 若小于等于1 输出原链表
        if (k <= 1) {
            return l1;
        }

        Node current = l1;
        Node root = new Node(0);

        int count = 0;
        while (current != null) {
            for (int i = 0; i < k; i++) {
                count++;
            }


        }
        return null;
    }
}
