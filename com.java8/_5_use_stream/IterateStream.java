package _5_use_stream;

import java.util.stream.Stream;

/**
 * 迭代生成流
 */
public class IterateStream {
    public static void main(String[] args) {
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        // 斐波那契数列
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t->t[0])
                .forEach(System.out::println);


    }
}
