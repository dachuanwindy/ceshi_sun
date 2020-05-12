package com.XLH_study;

import java.awt.geom.Point2D;
import java.io.*;

public class TransientTest {
    public static void main(String[] args) {

        LabeledPoint label = new LabeledPoint("Book", 5.00, 5.00);

        try {
            System.out.println(label); // 写入前
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Label.txt"));
            out.writeObject(label);    //通过对象输出流，将label写入流中
            out.close();
            System.out.println(label);// 写入后
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Label.txt"));
            LabeledPoint label1 = (LabeledPoint) in.readObject();
            in.close();
            System.out.println(label1);// 读出并加1.0后
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class LabeledPoint implements Serializable {
    private String label;
    transient private Point2D.Double point;    //因为不可被序列化，所以需要加transient关键字

    public LabeledPoint(String str, double x, double y)//构造方法
    {
        label = str;
        point = new Point2D.Double(x, y);  //此类Point2D.Double不可被序列化
    }

    //因为Point2D.Double不可被序列化，所以需要实现下面两个方法
    private void writeObject(ObjectOutputStream out) throws IOException {

        out.defaultWriteObject();
        out.writeDouble(point.getX());
        out.writeDouble(point.getY());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {

        in.defaultReadObject();
        double x = in.readDouble() + 1.0;
        double y = in.readDouble() + 1.0;
        point = new Point2D.Double(x, y);
    }

    //重写toString方法
    public String toString() {
        return getClass().getName() + "[label = " + label + ", point.getX() = " + point.getX() + ", point.getY() = " +

                point.getY() + "]";
    }

}