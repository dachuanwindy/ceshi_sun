package shejimoshi.Observer_Mode.observer_modle;

import shejimoshi.Observer_Mode.observer_modle.observers.BaiduWeather;
import shejimoshi.Observer_Mode.observer_modle.observers.SinaWeather;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 天气预报观察者模式测试
 * @date 2020/5/2 13:19
 */
public class ClientTest {
    public static void main(String[] args) {
        WeatherCenter weatherCenter = new WeatherCenter();
        weatherCenter.register(new BaiduWeather());
        weatherCenter.register(new SinaWeather());
        // 新浪获取最新的天气信息通知到各个中心

        weatherCenter.updateCentData(new WeatherPo(11, 2, 4));
        weatherCenter.notifyAllCenter();
    }
}
