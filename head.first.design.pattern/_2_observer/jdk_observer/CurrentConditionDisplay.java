package _2_observer.jdk_observer;

import _2_observer.DataEntity;
import _2_observer.weather_observer.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * @Classname CurrentConditionDisplay
 * @Description TODO
 * @Date 2020/1/1 17:25
 * @Created by Super Man
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {
    DataEntity dataEntity;
    Observable weatherData;

    public CurrentConditionDisplay(Observable weatherData) {
        this.weatherData = weatherData;
        weatherData.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("temp : " + dataEntity.getTemp() + " humidity : " +
                dataEntity.getHumidity() + " pressure : " + dataEntity.getPressure());
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            // 这里用pull，可以更加灵活地取得观察者所需数据
            this.dataEntity = weatherData.getDataEntity();
            display();
        }
    }
}
