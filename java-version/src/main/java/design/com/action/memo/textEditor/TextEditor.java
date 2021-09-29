package design.com.action.memo.textEditor;


import java.util.LinkedList;

public class TextEditor {
    public static void main(String[] args) {
        //使用这个文本编辑器
        MyTextEditor editor = new MyTextEditor("这里是初始文本，可能为文件中读取的值。");
        System.out.println("开始修改文本：");
        editor.append("添加文字1");
        editor.delWords();        //删除最后一个
//		editor.delWords(2);		//删除最后2个	这两个方法是没有问题的，这里避免控制台输出太多，取消这两次修改
//		editor.delWords(1,5);	//删除前面5个
        System.out.println("开始恢复：");
        for (int i = 0; i < 10; i++) editor.recoverMemento();//恢复大于实际修改的次数不会出错，只会将文本设为o初始化状态
        System.out.println("开始重做：");
        for (int i = 0; i < 10; i++) editor.redo();        //重做大于实际恢复的次数不会出错，只会将文本设为最后状态
        System.out.println("再次恢复：");
        for (int i = 0; i < 10; i++) editor.recoverMemento();//恢复大于实际修改的次数不会出错，只会将文本设为o初始化状态
        System.out.println("再次重做：");
        for (int i = 0; i < 10; i++) editor.redo();        //重做大于实际恢复的次数不会出错，只会将文本设为最后状态
        System.out.println("再次恢复：");
        for (int i = 0; i < 10; i++) editor.recoverMemento();//恢复大于实际修改的次数不会出错，只会将文本设为o初始化状态
        editor.append("添加文字2");
        System.out.println("再次重做：");
        for (int i = 0; i < 10; i++) editor.redo();        //重做大于实际恢复的次数不会出错，只会将文本设为最后状态
    }
}


interface IMemento {
};

// 发起人与负责人
class MyTextEditor {
    public StringBuffer text;
    // 模拟栈操作： 先进后出
    private LinkedList<IMemento> mementos;    // 保存快照
    private LinkedList<IMemento> unDos;  // 保存撤销操作

    // 构造器：不需要设置返回类型
    public MyTextEditor() {
        this("");
        System.out.println("-------" + this);
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

    // 创建快照
    public void createMemento() {
        mementos.push(new Memento(this));
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

    //内部类实现备忘录: 当前例子中备忘录对象就是编辑器文本内容
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