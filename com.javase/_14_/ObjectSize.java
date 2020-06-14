package _14_;

/**
 * 计算一个对象的大小
 * 1 可以用lucene包下的 RamUsageEstimator.shallowSizeOf方法计算大小
 * 2 对象大小： 对象头 + 内容
 *  对象头包括：地址（4b）+标记（8b）+数组长度(4)
 * 3 对象大小要和8位对齐，也就是必须是8的倍数
 * 4 对象里的属性，如果是基础数据类型就按基础数据类型大小来算，如果是引用数据类型就按4字节算
 */
public class ObjectSize {

}
