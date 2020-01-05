package _2_observer.jdk_observer;

import _2_observer.DataEntity;

/**
 * @Classname WeatherStation
 * @Description TODO
 * @Date 2020/1/1 18:06
 * @Created by Super Man
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        DataEntity dataEntity = new DataEntity();
        dataEntity.setHumidity(1);
        dataEntity.setTemp(20);
        dataEntity.setPressure(10);
        weatherData.setMeasurement(dataEntity);
    }
}
