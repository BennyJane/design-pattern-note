package design.com.action.strategry;

import design.com.action.strategry.Impl.SaveController;
import design.com.action.strategry.Impl.SaveToFile;
import design.com.action.strategry.Impl.SaveToRedis;

// 策略模式: 定义一组方法，将其封装起来，使其可以方便互换
public class TestDemo {
    public static void main(String[] args) {
        Object data = "数据";
        ISaveData saveData = new SaveToRedis();
        // 调用者：初始化特定的方法
        SaveController client = new SaveController(saveData);
        client.save(data);  // 使用该方法
        // 切换方法
        client.setSaveData(new SaveToFile());
        client.save(data);
    }
}
