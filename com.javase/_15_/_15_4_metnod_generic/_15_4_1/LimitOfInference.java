package _15_._15_4_metnod_generic._15_4_1;

import _8_._8_1_exec_1.Person;

import java.util.List;
import java.util.Map;

/**
 * @Classname LimitOfInference
 * @Description TODO
 * @Date 2020/1/7 22:32
 * @Created by Super Man
 */
public class LimitOfInference {
    static void f(Map<Person, List<? extends Person>> map){
        System.out.println(map.getClass().getSimpleName());;
    }
    /** java编程思想：如果将一个泛型方法的返回值作为参数，传递给另一个方法，这是编译器并不会做类型推断*/
    /** 编译器会认为，调用泛型方法后，器返回值被赋给一个Object类型的变量*/
    /** but 这里可以编译通过，可能是在哪个java版本里，把这个问题解决了。*/
    public static void main(String[] args) {
        f(New.map());
    }
}
