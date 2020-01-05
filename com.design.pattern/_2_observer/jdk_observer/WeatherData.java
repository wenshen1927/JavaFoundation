package _2_observer.jdk_observer;

import _2_observer.DataEntity;

import java.util.Observable;

/**
 * @Classname WeatherData
 * @Description TODO
 * @Date 2020/1/1 17:03
 * @Created by Super Man
 */
public class WeatherData extends Observable {
    DataEntity dataEntity;

    void setMeasurement(DataEntity dataEntity) {
        this.dataEntity = dataEntity;
        measurementChanged();
    }

    void measurementChanged(){
        setChanged();
        notifyObservers();
    }

    /**
     * 这是一个push的过程
     */
    @Override
    public void notifyObservers() {
        if (hasChanged()){
            super.notifyObservers(dataEntity);
        }
    }

    /**
     * 提供数据接口
     * @return
     */
    public DataEntity getDataEntity() {
        return dataEntity;
    }
}
