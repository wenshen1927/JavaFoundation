package _6_collect_stream;

import _4_stream.Dish;

import java.util.Arrays;
import java.util.List;

public class DishList {
    static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 600, Dish.Type.MEAT),
            new Dish("chicken", false, 500, Dish.Type.MEAT),
            new Dish("french fries", true, 800, Dish.Type.OTHER),
            new Dish("rice", true, 300, Dish.Type.OTHER),
            new Dish("season fruit", true, 200, Dish.Type.OTHER),
            new Dish("pizza", true, 600, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmons", false, 350, Dish.Type.FISH)
    );
}
