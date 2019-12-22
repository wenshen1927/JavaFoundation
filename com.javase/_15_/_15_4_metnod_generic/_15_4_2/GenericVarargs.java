package _15_._15_4_metnod_generic._15_4_2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyn
 * @description 泛型与可变参数列表
 * @date 2019-12-15 22:45
 */
public class GenericVarargs {
    public static <T> List<T> getList(T... args) {
        List<T> list = new ArrayList<>(16);
        for (T t :
                args) {
            list.add(t);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Object> list = getList("a", 1, new GenericVarargs());

        List<String> list1 = getList("a", "b", "c");// 作用相当于Arrays.asList（）
        for (String s : list1) {
            System.out.println(s);
        }
    }
}
