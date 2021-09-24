package design.com.action.visitor;

import design.com.action.visitor.user.UserOrdinary;
import design.com.action.visitor.user.UserVIP;
import design.com.action.visitor.visitor.Owner;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 访问者模式
 */
public class TestDemo {

    // TODO 目的：针对不同类型用户的某些属性进行不同的操作
    // 该集合中混合了不同对象的数据
    static ArrayList<User> users = new ArrayList() {
        {
            add(new UserOrdinary("普通用户短反馈"));
            add(new UserOrdinary("这是一个普通用户的比较长的反馈"));
            add(new UserVIP("VIP用户的短反馈"));
            add(new UserVIP("VIP用户的比较长的反馈反馈"));
        }
    };

    public static void main(String[] args) {
        // 访问者模式调用方法
        Visitor owner = new Owner();

        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            iterator.next().accept(owner);
        }


        // ordinary方法测试
        ordinary();
    }

    private static void ordinary() {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            // FIXME 因为接口User中没有定义getEstimation方法，所以这里无法直接调用该方法
            User res = iterator.next();
            System.out.println(res.getName());
        }

    }
}
