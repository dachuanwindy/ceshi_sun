package shejimoshi.Proxy_moshi.proxy_jdk8;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 我自己实现的机器
 * @date 2020/4/12 12:19
 */
public class MyCalculator implements Calculator {
    @Override
    public Integer add(Integer a, Integer b) {
        System.out.println("孙风川自己实现的计算器");
        return a + b;
    }

    @Override
    public Integer dev(int a, int b) {
        return 0;
    }
}
