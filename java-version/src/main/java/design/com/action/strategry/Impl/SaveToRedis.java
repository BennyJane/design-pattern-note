package design.com.action.strategry.Impl;

import design.com.action.strategry.ISaveData;

public class SaveToRedis implements ISaveData {
    @Override
    public void save(Object data) {
        System.out.println("数据：" + data + " 保存到Redis");
    }
}
