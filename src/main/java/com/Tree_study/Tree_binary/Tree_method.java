package com.Tree_study.Tree_binary;

public class Tree_method {
    public Node root;


    public void insertdata(int value, String svalue) {
        //封装当前节点；要插入的几点，肯定是个节点类型的
        Node newNode = new Node(value, svalue);
        //引用根节点，是通过根节点去查找父节点的
        Node current = root;
        //引用父节点
        Node parent;

        if (root == null) {
            root = newNode;
            return;
        } else {
            while (true) {
                //当前节点指向父节点，
                parent = current;
                //
                if (value > current.data) {
                    current = parent.rightchildren;
                    if (current == null) {
                        parent.rightchildren = newNode;
                        return;
                    }
                } else {
                    current = parent.leftchildren;
                    if (current == null) {
                        parent.leftchildren = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void deletNode(int value) {

    }

    public Node find(int value) {

//从根节点开始找，所以当前对象=root对象
        Node current = root;
//循环查找节点，当不是这个值时候，就开始查找，如果这个值大于当前节点，往Right 方向好走，
        // 否则往左方向走， 如果没找到，则返回空，
        while (current.data != value) {

            if (current.data > value) {
                current = current.leftchildren;
            } else {
                current = current.rightchildren;
            }
            if (current == null) {
                System.out.println("没找到当前值---");
                return null;
            }
        }
        return current;
    }


    //前序遍历 树的遍历
    public void Front_bianli(Node localnode) {

        if (localnode != null) {
            System.out.println(localnode.data + "   " + localnode.svalue);
            Front_bianli(localnode.leftchildren);
            Front_bianli(localnode.rightchildren);
        }
    }

    /**
     * 中序遍历
     */
    public void Mide_sort(Node localnode) {
        if (localnode != null) {
            Mide_sort(localnode.leftchildren);
            System.out.println(localnode.data + "   " + localnode.svalue);
            Mide_sort(localnode.rightchildren);
        }
    }
}


class Testmain {

    public static void main(String[] args) {
        System.out.println("二叉树学习");
        Tree_method tree = new Tree_method();
        tree.insertdata(23, "JMS");
        tree.insertdata(24, "KB");
        tree.insertdata(2, "EW");
        tree.insertdata(13, "Harden");
        tree.insertdata(3, "WDe");
        tree.insertdata(1, "Mac");
     /*   Node data = tree.find(23);
        System.out.println(data.data + "     " + data.svalue);*/
        //前序遍历
        tree.Front_bianli(tree.root);

        //中序遍历
        tree.Mide_sort(tree.root);

    }
}
