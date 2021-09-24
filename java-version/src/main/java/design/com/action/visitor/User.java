package design.com.action.visitor;

// 抽象元素
public interface User {
    void accept(Visitor visitor);

    // 使得该方法可以被父类User调用
    String getName();
}
