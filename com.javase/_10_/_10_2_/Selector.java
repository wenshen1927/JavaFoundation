package _10_._10_2_;

/**
 * 内部类有外部类所有元素的访问权限
 */
public interface Selector {
    // 检查序列是否到尾部
    boolean end();

    // 返回当前对象
    Object current();

    // 移到序列的下一个对象
    void next();
}
