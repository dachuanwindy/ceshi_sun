package com.NIO.NIO_study.Buffer_study;

import java.nio.ByteBuffer;

/**
 * @author sunfch
 * @create 2018-11-25 10:26
 * @desc Buffer_study
 **/
public class Buffer_study {


    public static void buffertest1() {
        String str = "abcdefg";

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        buffer.put(str.getBytes());
        System.out.println("-----------put-------------");
        System.out.println(buffer.capacity());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());



        buffer.flip();
        System.out.println("-----------flip -------------");
        System.out.println(buffer.capacity());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());


        byte[] get = new byte[buffer.limit()];
        buffer.get(get);
        System.out.println("-----------get() -------------");
        System.out.println(new String(get,0,get.length));
        System.out.println(buffer.capacity());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());

    }


    // 直接缓冲区，与非直接缓冲区
    /**
     *  直接缓冲区，在内存中开辟一段空间，直接与磁盘中的数据对应，这样就省去了copy环节 提高效率
     *
     * */
    public  static  void  buffertest2(){

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

        System.out.println(byteBuffer.isDirect());
    }

    public static void main(String[] args) {

//        buffertest1();

        buffertest2();
    }
}
