package _15_._15_2_class_generic._15_2_1_tuple;

/**
 * @author zhangyn
 * @description 三元组
 * @date 2019-12-13 00:23
 */
public class ThreeTuple<A, B, C> extends TwoTuple {
    public final C third;

    public ThreeTuple(A a, B b, C c) {
        super(a, b);
        this.third = c;
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + "," + third + ")";
    }
}
