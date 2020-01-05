package _2_observer.weather_observer;

import _2_observer.DataEntity;

/**
 * @Classname CurrentConditionDisplay
 * @Description TODO
 * @Date 2020/1/1 16:37
 * @Created by Super Man
 */
public class CurrentConditionDisplay implements Observer,DisplayElement {

    private DataEntity dataEntity;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        dataEntity.setTemp(temp);
        dataEntity.setHumidity(humidity);
        display();
    }

    @Override
    public void display() {
        System.out.println("Current condition : "+ dataEntity.getTemp() + " F degree "+ dataEntity.getHumidity() + " % humidity");
    }
}
