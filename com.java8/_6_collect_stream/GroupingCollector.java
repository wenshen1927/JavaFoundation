package _6_collect_stream;

import _4_stream.Dish;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 分组
 */
public class GroupingCollector {
    public static void main(String[] args) {
        // 根据类型分组
        final Map<Dish.Type, List<Dish>> map = DishList.menu.stream()
                .collect(Collectors.groupingBy(Dish::getType));
        final Set<Map.Entry<Dish.Type, List<Dish>>> entries = map.entrySet();
        for (Map.Entry<Dish.Type, List<Dish>> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue() + " ");
        }

        System.out.println("======================");

        // 分级分组，根据自定义的热量分组
        final Map<Dish.Type, Map<CaloricLevel, List<Dish>>> map2 = DishList.menu.stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.groupingBy(dish -> {
                            if (dish.getCalories() <= 400) {
                                return CaloricLevel.DIET;
                            } else if (dish.getCalories() <= 700) {
                                return CaloricLevel.NORMAL;
                            } else {
                                return CaloricLevel.FAT;
                            }
                        })));
        final Set<Map.Entry<Dish.Type, Map<CaloricLevel, List<Dish>>>> set1 = map2.entrySet();
        for (Map.Entry<Dish.Type, Map<CaloricLevel, List<Dish>>> typeMapEntry : set1) {
            System.out.println(typeMapEntry.getKey() + ":" + typeMapEntry.getValue());
        }

        final Map<Dish.Type, Long> countingMap = DishList.menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        System.out.println(countingMap);

        // 查找每个类型子组中热量最高的dish
        final Map<Dish.Type, Dish> map3 = DishList.menu.stream()
                .collect(Collectors.toMap(Dish::getType, Function.identity(), BinaryOperator.maxBy(Comparator.comparing(Dish::getCalories))));
        System.out.println(map3);
    }

    public enum CaloricLevel {
        DIET, NORMAL, FAT
    }
}
