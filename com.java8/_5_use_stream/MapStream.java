package _5_use_stream;

import _4_stream.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapStream {
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
        List<String> names = menu.stream().map(Dish::getName).collect(Collectors.toList());
        System.out.println(names);

        List<String> words = Arrays.asList("Java8", "Like", "TrumpSuck", "lonely");
        List<Integer> wordsCount = words.stream().map(String::length).collect(Collectors.toList());
        System.out.println(wordsCount);

        List<String[]> word = words.stream()
                .map(w -> w.split(""))
                .distinct()
                .collect(Collectors.toList());

        // flatMap的作用是把多个单独的流合并成一个流，即扁平化为一个流
        List<String> wordFlat = words.stream().map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(wordFlat);

        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        List<Double> pow2 = integers.stream().map(x -> Math.pow(x, 2)).collect(Collectors.toList());
        System.out.println(pow2);

        List<Integer> num1 = Arrays.asList(1, 2, 3);
        List<Integer> num2 = Arrays.asList(3, 4);

        List<int[]> pairs = num1.stream()
                .flatMap(i -> num2.stream().map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
        pairs.forEach(x-> System.out.println(Arrays.toString(x)));



    }
}
