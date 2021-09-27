package design.com.action.memo;

import com.sun.corba.se.impl.resolver.ORBInitRefResolverImpl;

// 自述式备忘录
public class MementoSelf {
    public static void main(String[] args) {
        // 发起人， 同时为负责人（管理状态存储与恢复）
        OriginatorCaretaker originatorCaretaker = new OriginatorCaretaker();
        originatorCaretaker.changeState("stateOne");    // 改变状态
        IMemento memento = originatorCaretaker.createMemento(); // 保存状态
        originatorCaretaker.changeState("stateTwo");
        originatorCaretaker.recoverMemento(memento);    // 恢复状态
    }
}

// 内部类在外部无法访问，也就无法出现内部类的子类或实例，
// 所以需要定义外部接口类
interface IMemento {

}

class OriginatorCaretaker {
    public String state;

    // 改变状态
    public void changeState(String state) {
        this.state = state;
    }

    // 创建快照：这个快照需要在外部保存
    public Memento createMemento() {
        return new Memento(this);
    }

    // 恢复状态
    // TODO 这里不能写 Memento类
    public void recoverMemento(IMemento memento) {
        Memento m = (Memento) memento;
        changeState(m.state);
    }


    // 内部类实现备忘录
    private class Memento implements IMemento {
        private String state;

        public Memento(OriginatorCaretaker originatorCaretaker) {
            this.state = originatorCaretaker.state;
        }
    }
}