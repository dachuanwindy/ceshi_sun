package shejimoshi.Observer_Mode.observer_modle.observers;

import shejimoshi.Observer_Mode.observer_modle.Observer;
import shejimoshi.Observer_Mode.observer_modle.WeatherPo;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/5/2 12:57
 */
public class SinaWeather implements Observer {


    /**
     * description: 更新天气
     *
     * @return void
     */
    @Override
    public void updateWeatherData(WeatherPo weatherPo) {
        System.out.println("更新挑起信息");
        printData(weatherPo);
    }
    public void printData(WeatherPo weatherPo) {
        System.out.println(weatherPo);
    }
}
