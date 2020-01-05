package _2_observer.weather_observer;

/**
 * @Classname Subject
 * @Description TODO
 * @Date 2020/1/1 16:21
 * @Created by Super Man
 */
public interface Subject {
    /**注册观察者*/
    void registerObserver(Observer observer);
    /**删除观察者*/
    void removeObserver(Observer observer);
    /**通知所有观察者*/
    void notifyObservers();
}
