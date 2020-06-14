package _5_use_stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 创建一个勾股数流
 */
public class TriangleNums {
    public static void main(String[] args) {
        Stream<double[]> stream = IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(
                                b -> new double[]{a, b, Math.sqrt(a * a + b * b)}
                        ).filter(t -> t[2] % 1 == 0));

    }
}
