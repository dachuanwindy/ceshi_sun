package SuanFa_study.SJJG_study.Linked;


class Nodee {
    public int data;

    public Nodee next;

    Nodee(int value) {
        this.data = value;
    }

    public void disply() {
        System.out.println(data + "   ");
    }
}

public class Linkede_2 {

    private Nodee first;

    private Nodee next;

    Linkede_2() {
        first = null;
    }

    //插入数据
    public void insertData_first(int value) {
        Nodee temp = new Nodee(value);
        if (first == null) {
            first = temp;
        } else {
            temp.next = first;
            first = temp;
        }
    }

    //删除数据
    public void deleteNode_first() {
        Nodee cureent = first;
        first = cureent.next;
    }

    public void deletNode(int value) {
        Nodee current = first;
        Nodee previous = first;
        while (current.data != value) {
            if (current.next == null) {
                System.out.println("没有当前值*********");
                return;
            }
            previous = current;
            current = current.next;
        }
        if (first == current) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
    }

    //查找数据

    public Nodee Find_data(int value) {
        Nodee current = first;
        while (current.data != value) {
            if (current.next == null) {
                System.out.println("没找到当前值");
                return null;
            }
            current = current.next;
        }
        return current;
    }


    // 显示数据
    public void diplay() {
        Nodee curreent = first;
        while (curreent != null) {
            System.out.print(curreent.data + "   ");
            curreent = curreent.next;
        }

    }
}

class Testmain {

    public static void main(String[] args) {
        System.out.println("链表结构测试");
        Linkede_2 linkede_2 = new Linkede_2();

        linkede_2.insertData_first(1222);
        linkede_2.insertData_first(12222222);
        linkede_2.insertData_first(1224442);
        linkede_2.insertData_first(12666622);
        //删除第一个元素（只删除头部元素）
//        linkede_2.deleteNode_first();

        linkede_2.deletNode(1224442);
        linkede_2.diplay();


        linkede_2.Find_data(1111);


    }
}