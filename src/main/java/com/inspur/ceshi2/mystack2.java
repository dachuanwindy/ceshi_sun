package com.inspur.ceshi2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class mystack2 {
    public static void main(String[] args) {
       /* MyStack<String> stack = new MyStack<String>();
        for (String s : "the prefect code".split(" ")) {//LIFO
            stack.push(s);
        }
        while (!stack.empty()) {
            System.out.print(stack.peek() + " ");
            stack.pop();
        }

        System.out.println();
        for (char s : "写了个一句话倒起来说的程序".toCharArray()) {//用例：正话反说
            stack.push(String.valueOf(s));
        }
        while (!stack.empty()) {
            System.out.print(stack.peek());
            stack.pop();
        }*/
        Date date = new Date();

        String datestring = dateTostring(date);

        System.out.print(datestring);


        File file = new File("D:\\fffffjbkfpt.dmp");
        System.out.println(file.getPath());
        String filepath = file.getParent();
        

        if (!file.exists()){
            file.mkdir();
        }
        System.out.println("能否正常创建文件");



        System.out.println(filepath);
    }


    public static String dateTostring(Date date) {


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

        String dateTostring = simpleDateFormat.format(date);

        return dateTostring;
    }
}