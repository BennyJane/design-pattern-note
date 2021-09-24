package design.com.action.templatemethod;

public class Template extends AbstractTemplate {
    // 继承AbstractTemplate，继承属性data，方法printData；需要实现抽象方法
    @Override
    void getData() {
        data = "data";
    }

    @Override
    void doData() {
        data = (String) data + data;
    }
}
