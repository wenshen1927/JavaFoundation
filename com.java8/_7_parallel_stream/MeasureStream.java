package _7_parallel_stream;

import java.util.function.Function;
import java.util.stream.LongStream;

/**
 * 测试并行流的性能
 */
public class MeasureStream {
    /**
     * 测试流的性能的框架,类似模板模式，计算10次是为了让编译器预热，取10次的最小值
     *
     * @param adder 计算函数
     * @param n n个数
     * @return
     */
    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            final long start = System.nanoTime();
            final Long sum = adder.apply(n);
            final long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }



    public static void main(String[] args) {
//        System.out.println("Sequential sum done in:" +
//                measureSumPerf(ParallelSum::sequentialSum, 10_000_000) + " msecs");
//
//        System.out.println("Iterative sum done in:" +
//                measureSumPerf(ParallelSum::iterativeSum, 10_000_000) + " msecs");

        System.out.println("RangeClosed sum done in:" +
                measureSumPerf(ParallelSum::rangedSum, 10_000_000) + " msecs");

        System.out.println("SideEffect sum done in:" +
                measureSumPerf(ParallelSum::sideEffectSum, 10_000_000) + " msecs");
    }
}
