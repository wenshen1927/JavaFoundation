package _15_._15_2_class_generic._15_2_1_tuple;

/**
 * @author zhangyn
 * @description 元组：将一组对象直接打包存储于其中的一个单一对象，仅调用一次方法就能返回多个对象.元组里的每个对象类型可以不同。
 * @date 2019-12-13 00:18
 */
public class TwoTuple<A, B> {
    /**
     * 声明为final：当使用这个成员变量的时候，只能读取，不能修改
     */
    public final A first;
    public final B second;

    public TwoTuple(A a, B b) {
        this.first = a;
        this.second = b;
    }
    @Override
    public String toString(){
        return "(" + first + "," + second + ")";
    }
}
