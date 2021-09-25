package design.com.action.observer;

import design.com.action.observer.entity.WeatherInfo;

public interface IWeatherService {
    void addClient(Client client);        //添加观察者

    boolean deleteClient(Client client);//删除观察者

    void notifyClients();                //通知

    void updateWeather(WeatherInfo info);//主题内容更新
}
