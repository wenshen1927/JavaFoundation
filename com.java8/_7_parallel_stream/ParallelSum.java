package _7_parallel_stream;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelSum {

    public static long sequentialSum(long n) {
        return Stream.iterate(1L,i -> i+1)
                .limit(n)
                .parallel()
                .reduce(0L,Long::sum);
    }

    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n ; i++) {
            result += i;
        }
        return result;
    }

    /**
     * 比用iterator迭代出来的流速度要快，
     * 因为rangeClosed是把数据先准备好了，而且返回值直接就是基本数据类型，不需要装箱拆箱成本
     * @param n
     * @return
     */
    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1,n)
                .parallel()
                .reduce(0L,Long::sum);
    }

    /**
     * 错误的并行流使用方法：
     * Accumulator 中有一个累加的共享变量，forEach中进行累加的时候，会更新这个变量，在多线程的情况下，就无法保证线程安全
     * @param n
     * @return
     */
    public static long sideEffectSum(long n) {
        Accumulator acc = new Accumulator();
        LongStream.rangeClosed(1,n)
                .parallel()
                .forEach(acc::add);
        return acc.total;
    }

    public static void main(String[] args) {
        final long l = sequentialSum(10);
        System.out.println(l);
    }
}
