package design.com.action.strategry.Impl;

import design.com.action.strategry.ISaveData;


/**
 * 实现不同策略切换的功能
 */
public class SaveController {
    // 保存特定的方法
    private ISaveData saveData;

    public SaveController(ISaveData saveData) {
        this.saveData = saveData;
    }

    // 修改不同策略
    public void setSaveData(ISaveData saveData) {
        this.saveData = saveData;
    }

    /**
     * 调用不同策略的入口方法
     *
     * @param data 接收的参数，待处理的对象
     */
    public void save(Object data) {
        saveData.save(data);
    }

}
