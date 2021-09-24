package design.com.action.visitor;

import design.com.action.visitor.user.UserOrdinary;
import design.com.action.visitor.user.UserVIP;

// 抽象访问者: 利用方法重载，实现不同对象的处理
public interface Visitor {
    void visit(UserVIP user);

    void visit(UserOrdinary user);

    // PS扩展：处理UserThree类型对象、处理
}
