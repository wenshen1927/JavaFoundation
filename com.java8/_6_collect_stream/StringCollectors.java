package _6_collect_stream;

import _4_stream.Dish;

import java.util.stream.Collectors;

/**
 * 字符串型的收集器
 */
public class StringCollectors {
    public static void main(String[] args) {
        final String nameJoining = DishList.menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
        System.out.println(nameJoining);
    }
}
