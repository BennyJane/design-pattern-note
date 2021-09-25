package design.com.action.state.impl;

import design.com.action.strategry.ISaveData;

public enum SaveMiddleData implements ISaveData {
    instance;

    @Override
    public void save(Object data) {
        System.out.println("保存到Mysql:" + data);
    }
}
