package _15_._15_4_metnod_generic;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangyn
 * @description
 * @date 2019-12-14 22:34
 */
public class StaticMethodGeneric<T> {
    T t;
    /**编译报错：static方法无法使用类的泛型*/
//    static void getGeneric(T t){}

    /** 但是可以用方法自己的泛型类型 */
    public static <A> Set<A> get(){
        return new HashSet<>();
    }
}
