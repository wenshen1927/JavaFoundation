package _6_collect_stream;

import _4_stream.Dish;

import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * 数字型收集器
 */
public class NumberCollectors {
    public static void main(String[] args) {
        // 菜单里有多少中菜
        final long count = DishList.menu.stream().map(Dish::getName).distinct().count();
        System.out.println(count);
        final Long count1 = DishList.menu.stream().collect(Collectors.counting());
        System.out.println(count);
        final long count2 = DishList.menu.stream().count();
        System.out.println(count);

        // 查找流中的热量最大的菜和最小的菜
        DishList.menu
                .stream()
                .max(Comparator.comparing(Dish::getCalories))
                .ifPresent(x -> System.out.println(x.getName()));

        DishList.menu
                .stream()
                .min(Comparator.comparing(Dish::getCalories))
                .ifPresent(x -> System.out.println(x.getName()));

        DishList.menu.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)))
                .ifPresent(x -> System.out.println(x.getName()));

        // 对流中的一个数值字段求和
        final int sum = DishList.menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(sum);

        final Integer sum1 = DishList.menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(sum1);

        final Integer sum2 = DishList.menu.stream().map(Dish::getCalories).reduce(Integer::sum).orElse(0);
        System.out.println(sum2);

        // 求菜单的热量平均数值
        DishList.menu.stream().mapToLong(Dish::getCalories).average().ifPresent(System.out::println);

        final Double avg = DishList.menu.stream().collect(Collectors.averagingLong(Dish::getCalories));
        System.out.println(avg);

        final String summary = DishList.menu.stream().mapToLong(Dish::getCalories).summaryStatistics().toString();
        System.out.println(summary);

    }
}
