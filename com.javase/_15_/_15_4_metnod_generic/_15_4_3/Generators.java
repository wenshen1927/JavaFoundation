package _15_._15_4_metnod_generic._15_4_3;

import _15_._15_3_interface_generic._15_3_fibonacci.Fibonacci;
import _15_._15_3_interface_generic._15_3_generator.Coffee;
import _15_._15_3_interface_generic._15_3_generator.CoffeeGenerator;
import _15_._15_3_interface_generic._15_3_generator.Generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangyn
 * @description
 * @date 2019-12-15 22:55
 */
public class Generators {
    /**
     * 填充一个Collection对象
     *
     * @param coll
     * @param gen  生成器
     * @param n
     * @param <T>
     * @return
     */
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    public static <T> List<T> fill(List<T> list, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            list.add(gen.next());
        }
        return list;
    }

    public static <T> LinkedList<T> fill(LinkedList<T> list, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            list.add(gen.next());
        }
        return list;
    }



    public static void main(String[] args) {
        Collection<Coffee> coffeeList = fill(new ArrayList<>(), new CoffeeGenerator<Coffee>(), 10);
        for (Coffee coffee : coffeeList) {
            System.out.println(coffee);
        }

        Collection<Integer> fibList = fill(new ArrayList<>(), new Fibonacci(), 12);
        for (Integer i : fibList) {
            System.out.println(i);
        }

        LinkedList<Integer> linkedList = fill(new LinkedList<>(), new Fibonacci(), 12);
        for (Integer integer : linkedList) {
            System.out.println(integer);
        }

    }
}
