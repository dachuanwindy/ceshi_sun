package inspur.BXD_JCSP.Bixiangdong_IO.File_study;

import java.io.*;

/**
 * IO 就是都是成对出现的，
 * <p>
 * 字节流（流的本质就是数据传输，byte[]字节的形式传输，）
 * inputstream
 * <p>
 * outputstream
 * <p>
 * <p>
 * 字符流（父类接口 ，其他子类都是实现这两个方法 reader 与writer）
 * reader
 * <p>
 * writer
 * <p>
 * <p>
 * 字节流与字符流直接的区别：
 * 1.读写单位不一样： 字节流是8bits为单位进行读写   字符流是根据码表映射读取数据；
 * 2. 处理对象不同： 字节流可以处理任何对象（图片，视频 数字等）， 而字符流只能处理字符相关的文件
 * <p>
 * 主要结论： 处理纯文本文档优先考虑字符流，其他均考虑字节流
 * *****************************
 */
public class Testmain {


    // 这个是字符流读取--
    public static void main(String[] args) {
        System.out.println("IO_study······");

      /*  try {

            FileReader fileReader = new FileReader("D:\\111.txt");
            while (true) {
                int ff = fileReader.read();
                if (ff == -1) {
                    break;
                }
                System.out.print(ff);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            char_read();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/


 /*       file_read();
        PCT_copy();
        long start = System.currentTimeMillis();
        Mp3_copy();
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("复制的时间是" + time + "毫秒");*/

        B b = new B();
        try {
            b.Read_log();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //通过字符流的方式读取

    public static void char_read() throws IOException {

/*
        FileReader fileReader = new FileReader("D:\\111.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E:\\sunfenghcuan111.txt"));
        bufferedWriter.write("dfdfdfddf");
        bufferedReader.close();
        bufferedWriter.close();
*/

    }
//实现copy功能


    public static void file_read() {

        FileInputStream fileInputStream = null;
        try {
            Reader reader = new BufferedReader(new FileReader("C:\\Users\\sunfch\\Desktop\\gg_monitor_20180305_1420"));

            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 图片是用的字节流去复制，因为字符流只能传输纯文本文档！
     * <p>
     * 字符流也可以去复制，但是复制之后的图片是乱码，是不能看的。【writer, reader   printwriter  printreader 】
     * <p>
     * 字节流是： 【 inputstream  outputstream    fileinputstream  fileoutpustream 】
     */
    public static void PCT_copy() {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream("D:\\111.jpg");
            fileOutputStream = new FileOutputStream("D:\\dfdfdfdfdfdfdfdfd.jpg");
            byte[] bfff = new byte[1024 * 1024 * 5];
            int len = 0;
            while ((len = fileInputStream.read(bfff)) != -1) {
                fileOutputStream.write(bfff);
            }
            System.out.println("复制完成-----");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void Mp3_copy() {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream("D:\\1111.avi"));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("D:\\3333.avi"));
            int len = 0;

            while ((len = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(len);
            }
            System.out.println("电影复制完成---");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class B {

    public void Read_log() throws IOException {
        FileReader fr = new FileReader("C:\\Users\\sunfch\\Desktop\\gg_monitor_20180305_1420");
        //可以换成工程目录下的其他文本文件
        BufferedReader br = new BufferedReader(fr);
        while (br.readLine() != null) {
            String s = br.readLine();
            if (s.contains("联调环境纳服B库")) {
                System.out.println("联调环境纳服B库");
            }
            System.out.println(s);
        }
    }

}
