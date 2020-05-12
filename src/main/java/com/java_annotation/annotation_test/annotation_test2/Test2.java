package com.java_annotation.annotation_test.annotation_test2;


        import com.java_annotation.annotation_test.annotation_interface.TestA;

/**
 * @author sunfch
 * @create 2018-08-26 15:44
 * @desc 注解接口使用
 **/

@TestA(name = "ceshi", Gid = Long.class, id = 9)
public class Test2 {

    public String test;
    @TestA(name = "public.method", Gid = long.class, id = 1)
    public void ceshiMehtod() {
    }


}
