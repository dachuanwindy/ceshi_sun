package SuanFa_study.java_suanfa_stack;

/**
 * @author sunfch
 * @create 2018-11-09 10:51
 * @desc 数组和链表分别实现 栈；
 **/
public class LinkedStack {
    private Node top;

    private int size = 0;

    LinkedStack() {
        top = null;
    }

    class Node {
        private int data;
        private Node next;

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
        if (top == null) {
            throw new RuntimeException("当前栈为空");

        } else {
            int value = top.data;
            top = top.next;
            return value;
        }
    }

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();

        stack.push(12);

        stack.push(15);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.pop();




    }


}
