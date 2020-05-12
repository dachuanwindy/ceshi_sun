package shejimoshi.Observer_Mode.observer_modle;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 观察者的实现
 * @date 2020/5/2 12:54
 */
public interface Observer {
    /**
     * description: 更新天气
     *
     * @param
     * @return weatherPo
     */
    void updateWeatherData(WeatherPo weatherPo);

}
