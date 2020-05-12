package shejimoshi.Observer_Mode.observer_modle.observers;

import shejimoshi.Observer_Mode.observer_modle.Observer;
import shejimoshi.Observer_Mode.observer_modle.WeatherPo;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 百度天气实现通知
 * @date 2020/5/2 12:57
 */
public class BaiduWeather implements Observer {


    /**
     * description: 更新天气
     *
     * @return void
     */
    @Override
    public void updateWeatherData(WeatherPo weatherPo) {
        System.out.println("百度天气预报信息");
        printData(weatherPo);
    }

    public void printData(WeatherPo weatherPo) {
        System.out.println(weatherPo);
    }
}
