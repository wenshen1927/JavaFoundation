package _1_feature;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Filter {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();

        inventory.add(new Apple("green",20D));
        inventory.add(new Apple("red",20D));
        inventory.add(new Apple("red",10D));
        inventory.add(new Apple("green",10D));
        inventory.add(new Apple("green",5D));
        List<Apple> list1 = filterApples(inventory, Filter::isGreenApple);
        System.out.println(list1);

        List<Apple> list2 = filterApples(inventory, Filter::isHeavyApple);
        System.out.println(list2);


        // lambda 方式,对于只用一次且简单的函数，使用匿名函数更简洁灵活
        List<Apple> list3 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()) &&
                a.getWeight() >= 10);
        System.out.println(list3);

    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 10;
    }

    /**
     *
     * @param inventory
     * @param p 谓词
     * @return
     */
    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            // 传进来一个参数化行为
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

}
