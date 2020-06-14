package _2_behavior_paramlize;

import _1_feature.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class FilterApple {
    static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            // 传进来一个参数化行为
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 使用泛型，将类型也抽象化
     * @param list
     * @param p
     * @param <T>
     * @return
     */
    static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t : result) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    static void prettyPrintApple(List<Apple> apples,PrintPredicate p) {
        for (Apple apple : apples) {
            String test = p.accept(apple);
            System.out.println(test);
        }
    }

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();

        inventory.add(new Apple("green",20D));
        inventory.add(new Apple("red",20D));
        inventory.add(new Apple("red",10D));
        inventory.add(new Apple("green",10D));
        inventory.add(new Apple("green",5D));

        // Lambda方式
        List<Apple> list = filterApples(inventory, (Apple apple) -> "red".equals(apple.getColor()));
        System.out.println(list);
    }
}
class RedApplePredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "red".equals(apple.getColor());
    }
}

class HeavyApplePredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 10;
    }
}
