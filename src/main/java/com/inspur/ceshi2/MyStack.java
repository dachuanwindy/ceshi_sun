package com.inspur.ceshi2;

import java.util.LinkedList;

public class MyStack<T> {
    private LinkedList<T> storage = new LinkedList<T>();

    public synchronized void push(T e) {//需要加上同步
        storage.addFirst(e);
    }

    public T peek() {
        return storage.getFirst();
    }

    public void pop() {
        storage.removeFirst();
    }

    public boolean empty() {
        return storage.isEmpty();
    }

    public String toString() {
        return storage.toString();
    }


}

// T的作用是泛型，是指可以接受任何类型的参数
class stack_2<T> {
    private LinkedList<T> stack = new LinkedList<T>();

    public synchronized void push(T e) {
        stack.addFirst(e); // 进栈，将值方式堆栈中
    }

    public T peek() {
        return stack.getFirst(); // 获取当前的栈值
    }

    public void pop() {
        stack.removeFirst();//出栈删除最顶端的值
    }

    public boolean isEmpty() {

        return stack.isEmpty(); // 判断栈是否为空
    }

}



