package design.com.action.observer.Impl;

import design.com.action.observer.Client;
import design.com.action.observer.entity.WeatherInfo;

public class ClientAndroidClient implements Client {

    private static String name = "安卓服务";
    private WeatherInfo info;

    @Override
    public void getWeather(WeatherInfo weatherInfo) {
        this.info = weatherInfo;
        dealMsg();
    }

    private void dealMsg() {
        System.out.println(name + "收到最新天气：time=" + info.getTime() + "msg=" + info.getWeather() + "。马上开始推送消息...");
    }
}

