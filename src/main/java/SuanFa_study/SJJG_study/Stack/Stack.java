package SuanFa_study.SJJG_study.Stack;

/**
 * @author sunfch
 * @create 2018-10-07 11:13
 * @desc 堆栈实现
 **/
public class Stack {

    private String arr[];

    private int lenth = 10;

    private int top; //刚开始堆栈中没有数据


    //     不带参数的构造函数
    public Stack() {
        arr = new String[lenth];
        top = -1;

    }

    //    带参数的构造函数
    public Stack(int size) {
        arr = new String[size];
        top = -1;
    }

    public void push(String value) {
        arr[++top] = value;
    }

    public  String pop(){
        return  arr[top--];
    }

}
