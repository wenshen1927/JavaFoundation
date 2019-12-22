package _15_._15_2_class_generic._15_2_1_tuple;

/**
 * @author zhangyn
 * @description 使用元组
 * @date 2019-12-13 00:26
 */
public class TupleTest {
    static TwoTuple<String, Integer> f() {
        return new TwoTuple<>("hi", 47);
    }

    static ThreeTuple<String, Integer, Double> g() {
        return new ThreeTuple<>("a", 11, 1.55);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = TupleTest.f();
        System.out.println(ttsi);
//        ttsi.first = "a"; // 编译错误，因为该变量是final的，只能被初始化一次
        ThreeTuple<String, Integer, Double> g = TupleTest.g();
        System.out.println(g);
    }
}
