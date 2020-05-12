package SuanFa_study.java_suanfa_stack;

/**
 * @author sunfch
 * @create 2018-11-09 0:03
 * @desc 链表结构实现
 **/
public class MyLinkedStack {

    private Node top;

    private int size = 0;

    MyLinkedStack() {
        top = null;
    }


    class Node {
        public int data;
        public Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public void push(int data) {

        Node newnode = new Node(data);
        if (top == null) {
            top = newnode;
        } else {
            newnode.next = top;
            top = newnode;
        }
        size++;
    }

    public int pop() {
        if (top == null) throw new RuntimeException("站为空");
        else {
            int temp = top.data;
            top = top.next;
            size--;
            return temp;
        }
    }

    public static void main(String[] args) {
        MyLinkedStack stack = new MyLinkedStack();
        stack.push(12);
        stack.push(13);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
//        System.out.println(stack.pop());
    }
}
