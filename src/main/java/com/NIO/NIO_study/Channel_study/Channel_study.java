package com.NIO.NIO_study.Channel_study;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author sunfch
 * @create 2018-11-25 11:30
 * @desc 通道的学习
 **/
public class Channel_study {


    //方式一 通过JVM缓冲区 进行操作
    public static void channel_study() throws IOException {
        //  获取输入流，输出流
        FileInputStream fileInputStream = new FileInputStream("11.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("22.jpg");

        // 获取通道。输入流 输出流 通道。
        // 注意：通道是不能传输数据的，必须结合缓冲区来使用的；
        FileChannel channel = fileInputStream.getChannel();
        FileChannel channelout = fileOutputStream.getChannel();

        /**
         * 创建缓冲区
         * */
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (channel.read(byteBuffer) != -1) { // 等于-1 证明是数组中的数据已经满了
            //切换状态，buffer由读变为写
            byteBuffer.flip();
            // 将buffer 中的数据写入到channelout 中去
            channelout.write(byteBuffer);
            // 清空缓冲区；
            byteBuffer.clear();
        }

        //注意关闭通道，关闭读入写出流
        channel.close();
        channelout.close();
        fileInputStream.close();
        fileOutputStream.close();

    }

    public void test() throws IOException {

        //读取输入流的通道；
        FileChannel fileinputchannale = new FileInputStream("").getChannel();
        FileChannel fileoutputchannle = new FileOutputStream("dd").getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1023);

        //读：判断是否读入，若读入，则
        while (fileinputchannale.read(byteBuffer) != -1) {
            fileoutputchannle.write(byteBuffer);
            byteBuffer.clear();
        }

        //读取输出流的通道；
    }

    // 方式2 通过直接内存 然后操作，这个执行效率更高；

    public static void test2() throws IOException {

        //路径
        FileChannel inchannle = FileChannel.open(Paths.get("dd.jpg"), StandardOpenOption.READ);
        FileChannel outchannel = FileChannel.open(Paths.get("22.jpg"), StandardOpenOption.READ, StandardOpenOption.WRITE);

        // 内存映射文件
        MappedByteBuffer mapperread = inchannle.map(FileChannel.MapMode.READ_ONLY, 0, inchannle.size());
        MappedByteBuffer mapperout = outchannel.map(FileChannel.MapMode.READ_WRITE, 0, inchannle.size());

        //直接对缓冲区的文件进行操作；
        byte[] bs = new byte[mapperread.limit()];
        mapperread.get(bs);
        mapperout.put(bs);

        inchannle.close();
        outchannel.close();
    }


    // 通道传输的另一种方式
    public static void ceshi() throws IOException {
        FileChannel inchannel = FileChannel.open(Paths.get(""), StandardOpenOption.READ);
        FileChannel outchannel = FileChannel.open(Paths.get(""), StandardOpenOption.READ, StandardOpenOption.WRITE);
        // 这样就能完成数据的阐述，而且传输速度很快；
        inchannel.transferTo(0, inchannel.size(), outchannel);

    }


    public static void main(String[] args) {

    }
}
