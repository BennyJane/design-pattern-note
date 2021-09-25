package design.com.action.observer;

import design.com.action.observer.entity.WeatherInfo;

// 观察者
public interface Client {
    void getWeather(WeatherInfo weatherInfo);
}
