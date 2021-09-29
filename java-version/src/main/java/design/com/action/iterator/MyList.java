package design.com.action.iterator;

public interface MyList<T> {
    MyIterator<T> iterator();   // 返回迭代器

    //添加元素到列表中
    boolean add(T t);

    // 得到元素
    T get(int index);

    // 删除末尾元素
    T remove();

    // 删除指定元素
    boolean remove(T element);

    // 删除指定索引的元素
    T remove(int index);

    // 修改指定位置元素
    boolean set(int index, T element);

    // 返回列表长度
    int size();

}
