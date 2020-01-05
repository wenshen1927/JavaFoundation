package _2_observer.weather_observer;

/**
 * @Classname StatisticDisplay
 * @Description TODO
 * @Date 2020/1/1 16:50
 * @Created by Super Man
 */
public class StatisticDisplay implements Observer,DisplayElement{
    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    public StatisticDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = "+temperature);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
