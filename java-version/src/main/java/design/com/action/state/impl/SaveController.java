package design.com.action.state.impl;

import design.com.action.strategry.ISaveData;

public class SaveController {
    private ISaveData saveData;

    public void save(String data) {
        //为了演示，此处的大的数据其实也是很小的
        if (data.length() < 1 << 2)
            // 没有实例化操作
            saveData = SaveSmallData.instance;
        else if (data.length() < 1 << 4)
            saveData = SaveMiddleData.instance;
        else
            saveData = SaveBigData.instance;
        saveData.save(data);
    }

}
