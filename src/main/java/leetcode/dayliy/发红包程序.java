package leetcode.dayliy;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 实现一个发红包程序
 * @date 2020/7/2 22:14
 */
public class 发红包程序 {

    public static void main(String[] args) {
        System.out.println("实现发红包的程序");
    }

    /**
     * @description: 发红包程序,  金钱 * (个人点数/总点数)
     * @author sunfch
     * @date 2020/7/2 22:16
     */

    public static void method(int money, int count) {

        //每个人的绩效点
        List<Integer> personCounts = new ArrayList<>();

        List<Integer> hongBao = new ArrayList<>();

        int totalPersonCounts = 0;
        for (int i = 0; i < count; i++) {
            int personCount = RandomUtils.nextInt(0, 99) + 1;
            personCounts.add(personCount);
            totalPersonCounts += personCount;
        }

        int totalDivMoney = 0;
        for (int i = 0; i < personCounts.size() - 1; i++) {
            int hongBao2 = money * personCounts.get(i) / totalPersonCounts;
            hongBao.add(hongBao2);
            totalDivMoney += hongBao2;
        }
    }

}
