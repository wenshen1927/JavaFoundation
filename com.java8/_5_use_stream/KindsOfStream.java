package _5_use_stream;

import _4_stream.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KindsOfStream {
    static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 800, Dish.Type.MEAT),
            new Dish("chicken", false, 800, Dish.Type.MEAT),
            new Dish("french fries", true, 800, Dish.Type.MEAT),
            new Dish("rice", true, 800, Dish.Type.MEAT),
            new Dish("season fruit", true, 800, Dish.Type.MEAT),
            new Dish("pizza", true, 800, Dish.Type.MEAT),
            new Dish("prawns", false, 800, Dish.Type.MEAT),
            new Dish("salmons", false, 800, Dish.Type.MEAT)
    );

    public static void main(String[] args) {
        // filter,接受一个Predicate接口
        List<Dish> vage = menu.stream().filter(p -> p.getCalories()>1000).collect(Collectors.toList());
        System.out.println(vage);// vage 是空list [],而不是null

        // distinct
        List<Integer> nums = Arrays.asList(1, 2, 2, 1, 3, 4, 5, 6, 7, 8);
        nums.stream().filter(p->p % 2==0).distinct().forEach(System.out::println);

        // limit
        List<Dish> low = menu.stream().filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(low);

        // skip(n) 跳过n个元素
        List<Dish> skip = menu.stream().filter(p -> p.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(skip);

        List<Dish> notVage = menu.stream().filter(p -> !p.isVagetaruian()).collect(Collectors.toList());
        System.out.println(notVage);

        List<Dish> meats = menu.stream().filter(p -> p.getType() == Dish.Type.MEAT).collect(Collectors.toList());
        System.out.println(meats);


    }
}
