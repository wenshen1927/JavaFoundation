package _5_use_stream;

import _4_stream.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceStream {
    static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 100, Dish.Type.MEAT),
            new Dish("beef", false, 200, Dish.Type.MEAT),
            new Dish("chicken", false, 200, Dish.Type.MEAT),
            new Dish("french fries", true, 800, Dish.Type.MEAT),
            new Dish("rice", true, 800, Dish.Type.MEAT),
            new Dish("season fruit", true, 800, Dish.Type.MEAT),
            new Dish("pizza", true, 800, Dish.Type.MEAT),
            new Dish("prawns", false, 800, Dish.Type.MEAT),
            new Dish("salmons", false, 800, Dish.Type.MEAT)
    );

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer result = nums.stream().reduce(0, Integer::sum);
        nums.stream().reduce((x,y) -> x*y).ifPresent(System.out::println);
        System.out.println(result);

        menu.stream().map(x->1).reduce(Integer::sum).ifPresent(System.out::println);
        long count = menu.size();
        System.out.println(count);

        System.out.println("===========");
        menu.stream()
                .filter(p -> p.getCalories() < 300)
                .map(Dish::getCalories).sorted()
                .reduce(Integer::sum).ifPresent(System.out::println);
    }
}
