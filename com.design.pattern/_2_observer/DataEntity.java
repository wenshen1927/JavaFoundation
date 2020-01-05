package _2_observer;

/**
 * @Classname _2_observer.DataEntity
 * @Description TODO
 * @Date 2020/1/1 17:29
 * @Created by Super Man
 */
public class DataEntity {
    private double temp;
    private double humidity;
    private double pressure;

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }
}
