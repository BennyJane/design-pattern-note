package design.com.action.memo.textEditor;


import java.util.LinkedList;

public class TextEditor {
}


interface IMemento {
};

// 发起人与负责人
class MyTextEditor {
    public StringBuffer text;
    private LinkedList<IMemento> mementos;    // 保存快照
    private LinkedList<IMemento> unDos;  // 保存撤销操作

    // 构造器：不需要设置返回类型
    public MyTextEditor() {
        this("");
    }

    public MyTextEditor(String defaultStr) {
        text = new StringBuffer(defaultStr);
        mementos = new LinkedList<IMemento>();
        unDos = new LinkedList<IMemento>();
    }

    // 清空链表
    public void clearHistory() {
        mementos.clear();
        unDos.clear();
    }

    // 创建快照
    public void createMemento() {
        mementos.push(new Memento(this));
    }

    public void append(String appendStr) {
        if (appendStr == null || appendStr.length() == 0) {
            return;
        }
        createMemento();
        text.append(appendStr);
        print();
        unDos.clear();
    }

    //删除最后一个
    public void delWords() {
        delWords(1);
    }

    public void delWords(int n) {
        if (n < 1 || n > text.length()) {
            return;
        }

        delWords(text.length() - n + 1, text.length());
    }

    //删除中间start到end的字符,第一个文字为第一个(而不是0)
    public void delWords(int start, int end) {
        if (start < 1 || end > text.length() + 1) return;
        createMemento();
        text = text.delete(start - 1, end);
        print();
    }


    public void reset(String text) {
        this.text = new StringBuffer(text);
    }

    //恢复状态
    public boolean recoverMemento() {
        Memento memento = (Memento) mementos.poll();
        if (memento == null) return false;
        unDos.push(new Memento(this));
        reset(memento.state);
        print();
        return true;
    }

    //redo,redo的操作也可以恢复！
    public boolean redo() {
        Memento memento = (Memento) unDos.poll();
        if (memento == null) return false;
        createMemento();
        reset(memento.state);
        print();
        return true;
    }

    //内部类实现备忘录
    private class Memento implements IMemento {
        private String state;

        private Memento(MyTextEditor editor) {
            this.state = editor.text.toString();
        }
    }

    void print() {
        System.out.println("当前文本：" + text);
    }
}