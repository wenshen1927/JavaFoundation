package _15_._15_4_metnod_generic._15_4_6;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangyn
 * @description 实现数学中集合的交并补运算
 * 首先，集合是相同元素的集合，所以可以用泛型来定义相同的集合
 * @date 2019-12-21 21:20
 */
public class Sets {
    /**
     * 并集
     *
     * @param a
     * @param b
     * @param <T>
     * @return
     */
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    /**
     * 交集
     *
     * @param a
     * @param b
     * @param <T>
     * @return
     */
    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    /**
     * 补集
     *
     * @param <T>
     * @return
     */
    public static <T> Set<T> difference(Set<T> superSet, Set<T> subSet) {
        Set<T> result = new HashSet<>(superSet);
        result.removeAll(subSet);
        return result;
    }

    /**
     * 返回交集之外的元素
     * @param a
     * @param b
     * @param <T>
     * @return
     */
    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a,b),intersection(a,b));
    }

}
