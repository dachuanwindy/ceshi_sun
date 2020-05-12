package com.Reflect.reflect_ceshi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author sunfch
 * @create 2018-11-10 9:49
 * @desc 反射测试
 **/
public class ReflectTest {

    public static void main(String[] args) {
//        replaceword();
        System.out.println(ceshi("students. am i"));
    }

    public static void replaceword() {
        String value = "we are happey  ";
        String value1 = value.replace(" ", "**");
        System.out.println(value1);

        String vale2 = "we are happy  ";

        char[] arr = vale2.toCharArray();

        for (int i = 0; i < arr.length; i++) {
         /*   if (Character.isSpaceChar(arr[i])) {
                System.out.println("==========");

            }*/

            if (arr[i] == '\0') {
                System.out.println(">>>>>>>");
            }
            ;

        }

    }


    public void Inputoutput() throws FileNotFoundException {


        InputStream inputStream = new FileInputStream("");
    }


    public static String ceshi(String str) {



        String[] arry = str.split(" ");
        String result = "";

        for (int i = arry.length-1; i >= 0; i--) {
            String.valueOf(str.charAt(i)).equals(" ");
            result = result + arry[i]+" ";
        }
        return result;
    }
}



