package com.NIO;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;

/*
 *  利用buffer 去读取数据 并存放数据
 *
 * */
public class CopyFile {
    static public void main(String args[]) throws Exception {

        String infile = "c://test/nio_copy.txt";
        String outfile = "c://test/result.txt";

        FileInputStream fin = new FileInputStream(infile);
        FileOutputStream fout = new FileOutputStream(outfile);

        /**
         * @Description: 测试；
         * @Author: sunfch
         * @Date: 2019/2/21-19:24 
         * @Param: [args]
         * @Return: void
         */
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(""));
        // 获取读的通道
        FileChannel fcin = fin.getChannel();

        FileChannel finchan = fin.getChannel();
        FileChannel foutchannel = fout.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);
        // 获取写的通道
        FileChannel fcout = fout.getChannel();
        // 定义缓冲区，并指定大小
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true) {
            // 清空缓冲区
            buffer.clear();
            //从通道读取一个数据到缓冲区
            int r = fcin.read(buffer);
            //判断是否有从通道读到数据
            if (r == -1) {
                break;
            }
            //将buffer指针指向头部
            buffer.flip();
            //把缓冲区数据写入通道
            fcout.write(buffer);
        }
    }
}