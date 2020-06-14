package _5_use_stream;

import _4_stream.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindMatchStream {
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
        if (menu.stream().anyMatch(Dish::isVagetaruian)) {
            System.out.println("Yes");
        }

        if (menu.stream().allMatch(p->p.getCalories() < 1000)) {
            System.out.println("Yes");
        }

        if (menu.stream().noneMatch(p -> p.getCalories()>1000)) {
            System.out.println("Yes");
        }

        Optional<Dish> any = menu.stream()
                .filter(Dish::isVagetaruian)
                .findAny();
        menu.stream()
                .filter(Dish::isVagetaruian)
                .findAny()
                .ifPresent(d-> System.out.println(d.getName()));

        Optional<Dish> first = menu.stream()
                .filter(Dish::isVagetaruian)
                .findFirst();
        menu.stream()
                .filter(Dish::isVagetaruian)
                .findFirst().ifPresent(System.out::println);



    }
}
