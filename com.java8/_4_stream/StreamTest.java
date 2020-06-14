package _4_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
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
//       menu.stream()
////                .peek(p->{
////                    System.out.println(p.getName());
////                })
////                .filter(d -> {
////                    System.out.println("filter:" + d.getName());
////                    return d.getCalories() > 300;
////                })
////                .map(d -> {
////                    System.out.println("mapping:" + d.getName());
////                    return d.getName();
////                })
////                .limit(3)
////                .forEach(System.out::println);
//        System.out.println(names);

        long count = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .distinct()
                .limit(3)
                .count();
        System.out.println(count);
    }

}
