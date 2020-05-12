package SuanFa_study.SJJG_study.FirstLastlinked;


class Node {
    public int data;

    public Node next;

    public Node(int value) {
        this.data = value;
    }

    public void display() {

        System.out.print(data + "    ");
    }

}

public class Linked {
    private Node first;

    public Linked() {
        first = null;
    }


    // 插入节点

    public void insertvalue(int value) {
        Node node = new Node(value);
        node.next = first;
        first = node;

    }

    public Node deletfirst() {
        Node temp = first;
        first = temp.next;
        return first;
    }

    public void display() {
        Node current = first;
        while (current != null) {
            current.display();
//            System.out.println(current.data + "____");
            current = current.next;
        }

    }

    public Node search(int value) {

        Node current = first;
        while (current.data != value) {
            if (current.next == null) {
                System.out.println("没有值");
            }
            current = current.next;
        }
        return current;
    }

    public Node delete(int value) {
        Node current = first;
        Node previes = first;
        while (current.data != value) {
            if (current.next == null) {
                System.out.println("没有值要删除");
            }
            previes = current;
            current = current.next;
        }
        if (current == first) {
            first = first.next;
        } else {
            previes.next = current.next;
        }
        return current;
    }


    public static void main(String[] args) {

        Linked linked = new Linked();
        linked.insertvalue(12);
        linked.insertvalue(15);
        linked.insertvalue(20);
        linked.insertvalue(2222);

        linked.insertvalue(5555);

        linked.delete(2222);
        linked.display();
      /*  linked.display();

        linked.deletfirst();
        linked.display();

        //查找方法

        Node rusult = linked.search(15);
        rusult.display();*/
    }
}
