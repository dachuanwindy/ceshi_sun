package shejimoshi.Observer_Mode.observer_modle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 天气预报中心, 针对发生的数据实
 * @date 2020/5/2 13:08
 */
public class WeatherCenter {

    private List<Observer> observerList = new ArrayList<Observer>();

    /**
     * description:更新天气预报中的数据
     *
     * @param
     * @return void
     */
    private WeatherPo weatherPo;

    public void updateCentData(WeatherPo weatherPo) {
        this.weatherPo = weatherPo;
    }


    /**
     * description:
     *
     * @param observer 服务的注册中心
     * @return void
     */
    public void register(Observer observer) {
        observerList.add(observer);

    }

    /**
     * description: 将服务移除
     *
     * @param observer
     * @return void
     */
    public void removeRegister(Observer observer) {
        observerList.remove(observer);
    }

    /**
     * description: 通知所有的检查中心
     *
     * @param
     * @return void
     */
    public void notifyAllCenter() {
        for (Observer observer : observerList) {
            observer.updateWeatherData(weatherPo);
        }
    }
}
