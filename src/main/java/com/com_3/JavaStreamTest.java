package com.com_3;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2019/9/9 15:17
 */
public class JavaStreamTest {


    public static void main(String[] args) throws Exception {

        List<User> userList = new ArrayList<>();
        userList.add(new User(15, "A"));
        userList.add(new User(15, "A"));
        userList.add(new User(25, "B"));
        userList.add(new User(35, "C"));
        long count = userList.stream().distinct().count();
        System.out.println(count);
        long count1 = userList.stream().skip(3).distinct().count();
        System.out.println(count1);


        Stream<User> userStream = userList.stream().filter(a -> a.getAge() > 15);
        userStream.forEach(b -> System.out.println(b.getName()));

        ArrayList<String> a;

        BaseSuanda baseSuanda = new BaseSuanda();

        List<Double> cost = Arrays.asList(10.0, 20.0, 30.0);

    }
}

@Data
@AllArgsConstructor
class User {
    int age;
    String name;
}

/**
 * @author sunfch
 * @description: 基本算法，测试Java8 lambda 表达式
 * @date 2019/9/12 15:02
 */
class BaseSuanda {

    int add(int a, int b) {
        return a + b;
    }
}