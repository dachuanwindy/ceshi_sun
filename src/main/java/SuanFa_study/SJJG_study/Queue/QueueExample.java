package SuanFa_study.SJJG_study.Queue;

/**
 * @author sunfch
 * @create 2018-10-07 16:38
 * @desc 队列排序
 * <p>
 * 队列中最主要的元素是：队列头，队列尾，队列元素个数；
 * 然后根据这几个变量进行增删改查；
 **/


public class QueueExample {


    private int arr[];
    private int element;
    private int end;
    private int front;

    public QueueExample() {
        arr = new int[100];
        end = -1;
        front = 0;
        element = 0;
    }

    public void insert(int value) {
        arr[++end] = value;
        element++;
    }


    public boolean remove() {
        return false;
    }

    // 获取第一个元素
    public int peek() {
        return arr[front];
    }
}
