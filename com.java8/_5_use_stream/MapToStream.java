package _5_use_stream;

import _4_stream.Dish;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * 数值特化流:将一个流转换为IntStream,DoubleStream,LongStream
 */
public class MapToStream {
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
        // 转换为IntStream，然后进行加和计算
        int sum = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println(sum);

        // 转换为DoubleStream
        DoubleSummaryStatistics doubleSummaryStatistics = menu.stream().mapToDouble(Dish::getCalories).summaryStatistics();
        System.out.println(doubleSummaryStatistics);

        // 将特化流转换为对象流
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> boxed = intStream.boxed();
        boxed.forEach(System.out::println);

        // 特化流的max，返回值是OptionalInt，根据是否有最大值返回
        OptionalInt max = menu.stream().mapToInt(Dish::getCalories).max();
        int i = max.orElse(1);
        System.out.println(i);

        // 数值范围，有点类似Python里的range()函数
        IntStream intStream1 = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println(intStream1.count());
        Stream<Integer> integerStream2 = IntStream.range(1, 100).boxed().filter(n -> n % 2 == 0);
        System.out.println(integerStream2.count());


    }
}
