package _5_use_stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 函数生成流
 */
public class GenerateStream {
    public static void main(String[] args) {
        // generate 接受一个Supplier
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        IntStream.generate(()->1).limit(10).forEach(System.out::println);
    }
}
