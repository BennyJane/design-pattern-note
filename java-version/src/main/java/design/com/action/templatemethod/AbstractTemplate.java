package design.com.action.templatemethod;

public abstract class AbstractTemplate {
    // 定义的方法
    Object data;

    // 模板方法的核心
    void dealData() {
        // 打印输出数据
        printData();
        // 处理数据的多步操作
        getData();
        doData();
    }

    abstract void getData();

    abstract void doData();

    // 抽象类中实现的方法
    void printData() {
        System.out.println(data);
    }
}
