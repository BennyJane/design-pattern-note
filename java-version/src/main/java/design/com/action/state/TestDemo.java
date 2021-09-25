package design.com.action.state;

import design.com.action.state.impl.SaveController;

// 状态模式： 允许一个对象在其内部状态改变时，改变其行为模式
// 不同状态的定义使用enum， 以及单例模式
public class TestDemo {
    public static void main(String args[]) {
        String smallData = "小数据";
        String middleData = "介于小数据和大数据之间的数据";
        String bifgData = "这里就假定这是一个很大很大很大的数据";

        SaveController saveDataController = new SaveController();
        saveDataController.save(smallData);
        saveDataController.save(middleData);
        saveDataController.save(bifgData);
    }
}
