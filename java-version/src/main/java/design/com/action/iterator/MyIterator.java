package design.com.action.iterator;

public interface MyIterator<T> {
    boolean hasNext();  // 是否有下一个元素

    // 得到下一个元素
    T next();

    // 删除下一个元素
    T remove();
}
