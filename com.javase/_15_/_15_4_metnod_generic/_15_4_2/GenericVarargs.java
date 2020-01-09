package _15_._15_4_metnod_generic._15_4_2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyn
 * @description 泛型与可变参数列表
 * @date 2019-12-15 22:45
 */
public class GenericVarargs<E> {
    private E key;

    private E getKey(E key) {
        return this.key;
    }

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
        System.out.println(list);

        // 作用相当于Arrays.asList（）
        List<String> list1 = getList("a", "b", "c");
        System.out.println(list1);
        // List<T> list1 = getList("a", "b", "c", 1);

        String[] str = {"a", "b", "c"};
        List<String> list2 = getList(str);
        System.out.println(list2);
    }
}

class StaticGenerator<T> {
    /**
     * 如果在类中定义使用泛型的静态方法，需要添加额外的泛型声明(将这个方法定义成泛型方法) * 即使静态方法要使用泛型类中已经声明过的泛型也不可以。
     * 如:public static void show(T t){..},此时编译器会提示错误信息:
     * "StaticGenerator cannot be refrenced from static context"
     */
    public static <T> void show(T t) {
    }
}
