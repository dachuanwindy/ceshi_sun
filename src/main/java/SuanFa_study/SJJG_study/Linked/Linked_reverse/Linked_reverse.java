package SuanFa_study.SJJG_study.Linked.Linked_reverse;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sunfch
 * @create 2018-11-16 11:35
 * @desc 链表逆序输出_Java实现
 **/
public class Linked_reverse {

    public static class NodeList {
        int data;
        NodeList next;

        public NodeList(int data) {
            this.data = data;
        }
    }

    public static NodeList reverse(NodeList head) {
        if (head == null) {
            return null;
        }
        NodeList cur = head;
        NodeList oldhead = null;
        NodeList newhead = null;
        while (cur != null) {

            oldhead = cur.next;
            cur.next = newhead;
            newhead = cur;
            cur = oldhead;
        }

        return newhead;

    }

    public static void main(String[] args) {


    }


}
