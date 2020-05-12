package Linked.linked_study;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 链表快速排序
 * @date 2020/3/31 11:43
 */
public class LinkQuickSort {

    public static void main(String[] args) {
        System.out.println("=====");
    }

    public NodeData LinkNodeSort(NodeData node,NodeData end) {
        if (node == null || node.next == null) {
            return node;

        }
        NodeData first= null;
    //    NodeData


        return null;
    }


}


class NodeData {
    public String data;
    public NodeData next;

    NodeData(String data) {
        this.data = data;
    }

    public String toString(String data) {
        return data.toString();
    }
}