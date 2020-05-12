package SuanFa_study.java_suanfa_stack;

/**
 * @author sunfch
 * @create 2018-11-08 22:01
 * @desc 用数组实现
 **/
public class MyArrayStack {


    private int size;
    private int top = -1;
    private int[] arry;


    // 构造函数，初始化arry;
    public MyArrayStack(int size) {
        if (size > 0) {
            this.size = size;
            arry = new int[size];
        } else {
            throw new RuntimeException("size 值不能小于0");
        }
    }

    public void push(int value) {
        if (top >= size - 1) {
            System.out.println("当前栈已满");
        }
        arry[++top] = value;
    }

    public int pop() {
        if (top >= 0) {
            return arry[top--];
        } else {
            System.out.println("栈中没有数据了");
        }
        return -999;
    }

    public boolean isEmpty() {
        return top == -1;
    }


    public static void main(String[] args) {
        MyArrayStack stack = new MyArrayStack(5);

        stack.push(5);
        stack.push(6);
        stack.push(7);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }


}


