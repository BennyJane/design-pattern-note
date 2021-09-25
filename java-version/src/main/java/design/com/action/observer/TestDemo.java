package design.com.action.observer;

import design.com.action.observer.Impl.ClientAndroidClient;
import design.com.action.observer.Impl.ClientIphoneClient;
import design.com.action.observer.entity.WeatherInfo;
import design.com.action.observer.service.WeatherService;

// 观察者模式: 维护一对多的依赖关系，一个对象改变装填，所有依赖它的对象都会得到通知，并作出相应的变化
public class TestDemo {
    public static void main(String args[]) {
        //创建主题
        WeatherService service = WeatherService.instance;
        //添加观察者
        service.addClient(new ClientAndroidClient());
        service.addClient(new ClientIphoneClient());
        //更新主题
        service.updateWeather(new WeatherInfo(System.currentTimeMillis(), "多云"));
        service.updateWeather(new WeatherInfo(
                System.currentTimeMillis() + 1000 * 60 * 60 * 24, "多云转晴"));
        service.updateWeather(new WeatherInfo(
                System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 2, "晴"));
    }
}
