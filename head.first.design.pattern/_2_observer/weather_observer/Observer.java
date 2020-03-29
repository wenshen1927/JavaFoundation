package _2_observer.weather_observer;

/**
 * @Classname Observer
 * @Description TODO
 * @Date 2020/1/1 16:23
 * @Created by Super Man
 */
public interface Observer {
    /**更新气象信息 ， 这里直接传数据不好，试想，如果后面要传的数据类型变了，怎么办*/
    void update(float temp, float humidity, float pressure);
}
