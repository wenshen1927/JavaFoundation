package _2_observer.weather_observer;

/**
 * @Classname WeatherStation
 * @Description TODO
 * @Date 2020/1/1 16:47
 * @Created by Super Man
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        StatisticDisplay statisticDisplay  = new StatisticDisplay(weatherData);
        weatherData.setMeasurements(0.1f,0.2f,0.3f);
        weatherData.setMeasurements(0.2f,8,100);
        weatherData.setMeasurements(0.1f,0.2f,100);
    }
}
