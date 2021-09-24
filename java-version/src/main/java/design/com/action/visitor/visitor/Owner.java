package design.com.action.visitor.visitor;

import design.com.action.visitor.Visitor;
import design.com.action.visitor.user.UserOrdinary;
import design.com.action.visitor.user.UserVIP;

// 访问者: 减少了需要在User这个父类(父接口)中定义的方法数量
public class Owner implements Visitor {
    @Override
    public void visit(UserVIP user) {
        // 扩展： 处理User对象相关的更多功能
        String estimation = user.getEstimation();
        if (estimation.length() > 5) {
            System.out.println("记录一条有效反馈：" + estimation);
        }
    }

    @Override
    public void visit(UserOrdinary user) {
        String estimation = user.getEstimation();
        if (estimation.length() > 10)
            System.out.println("记录一条有效反馈：" + estimation);
    }
}
