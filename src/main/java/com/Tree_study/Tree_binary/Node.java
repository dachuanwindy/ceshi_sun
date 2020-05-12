package com.Tree_study.Tree_binary;

public class Node {

    //数据项
    public int data;

    public String svalue;
    // 左子节点
    public Node leftchildren;
    //右子节点
    public Node rightchildren;

    //构造函数初始化
    Node(int value, String svalue) {
        this.data = value;
        this.svalue = svalue;

    }
}
