package _15_._15_4_metnod_generic._15_4_5;

import _15_._15_2_class_generic._15_2_1_tuple.TwoTuple;

/**
 * @author zhangyn
 * @description
 * @date 2019-12-16 21:45
 */
public class Tuple {
    static <A, B> TwoTuple<A, B> tuple(A a, B b) {
        return new TwoTuple<>(a, b);
    }
}

class TupleTest {
    static TwoTuple<String, Integer> f() {
        return Tuple.tuple("hi", 1);
    }

    static TwoTuple f1() {
        // 这里不需要转型为参数化的twoTuple
        return (TwoTuple<String,Integer>) Tuple.tuple("hi", 2);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> f = f();
        System.out.println(f);
        System.out.println(f1());
    }
}
