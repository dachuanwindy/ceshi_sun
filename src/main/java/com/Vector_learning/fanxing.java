package com.Vector_learning;

//泛型总结

public class fanxing {

    //主函数
    public static void main(String[] args) {

        System.out.println("泛型测试");
        Box<String> box = new Box();
        box.setData("dfdfdfdf");
        box.getData();
        System.out.println(box.getData() + "哈哈哈");

        Box<Object> box1 = new Box<Object>();
        Box<Integer> box2 = new Box<Integer>();
        box2.setData(12);
        System.out.println("Integer 类型的参数" + box2.getData());

        Boxx<String> boxxxx = new Boxx<String>("sunfengchuan", "nauhcgnefnus");

        System.out.println(boxxxx.getDataa() + "娃哈哈");


    }

    static class Box<T> {


        private T data;

        public Box() {
        }

        public Box(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

    static class Boxx<String> {
        private String dataa;

        public Boxx() {

        }

        public Boxx(String dd, String ddf) {

            this.dataa = (String) (dd.toString() + ddf.toString());
        }

        public String getDataa() {
            return dataa;
        }

        public void setDataa(String dataa) {
            this.dataa = dataa;
        }

        /**
         * 泛型实现，使得方法更加通用，
         * 2，检查拼写错误，
         *
         *
         * */
    }
}


class Car {

    public int number;

    public int number(int n) {
        return n;
    }

    @Override
    public boolean equals(Object obj) {

        return super.equals(obj);
    }
}

class Car_main {

    public static void main(String args[]) {

        System.setProperty("sunfengchuan","ceshihi");

      String stringBuilder =  System.getProperties().toString();
     boolean flag=  stringBuilder.contains("sunfengchuan");

     System.out.println(flag);
    }
}