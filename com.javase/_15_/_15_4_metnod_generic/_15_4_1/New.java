package _15_._15_4_metnod_generic._15_4_1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyn
 * @description
 * @date 2019-12-15 22:21
 */
public class New {

    public static <K, V> Map<K, V> map() {
        return new HashMap<>(16);
    }

    public static void main(String[] args) {
        /**初始化的时候，不指定泛型，编译器可以自动推断出类型*/
        Map<String, Integer> map = New.map();
    }
}
