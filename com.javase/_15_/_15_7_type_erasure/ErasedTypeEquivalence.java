package _15_._15_7_type_erasure;

import java.util.ArrayList;

/**
 * @Classname ErasedTypeEquivalence
 * @Description 泛型在编译期的类型擦除机制
 * @Date 2019/12/25 22:16
 * @Created by Super Man
 */
public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class<? extends ArrayList> c1 = new ArrayList<String>(1).getClass();
        Class<? extends ArrayList> c2 = new ArrayList<Integer>(1).getClass();

        System.out.println(c1 == c2);
        System.out.println(c1.getSimpleName());
        System.out.println(c2.getSimpleName());
    }
}
