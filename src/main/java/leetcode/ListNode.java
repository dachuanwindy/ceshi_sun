package leetcode;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/6/2 08:28
 */
public class ListNode {
    @Getter
    @Setter
    public Node next;
    @Getter
    @Setter
    public int value;

    public ListNode(int value) {
        this.value = value;
    }
}

class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
    }
}
