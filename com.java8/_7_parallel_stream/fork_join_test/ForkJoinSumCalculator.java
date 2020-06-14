package _7_parallel_stream.fork_join_test;

import _7_parallel_stream.MeasureStream;
import _7_parallel_stream.ParallelSum;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

import static _7_parallel_stream.MeasureStream.measureSumPerf;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {
    /**
     * 待处理的任务（求和）数组
     */
    private final long[] number;

    /**
     * 子任务处理的数组的起始位置
     */
    private final int start;

    /**
     * 子任务处理的数组的终止位置
     */
    private final int end;

    /**
     * 不再将任务分解为子任务的数组大小阈值
     */
    private static final long THRESHOLD = 10_000;

    /**
     * 公共构造函数用来创建主任务
     *
     * @param number
     */
    public ForkJoinSumCalculator(long[] number) {
        this(number, 0, number.length);
    }

    /**
     * 私有构造函数用来创建子任务
     *
     * @param number
     * @param start
     * @param end
     */
    private ForkJoinSumCalculator(long[] number, int start, int end) {
        this.number = number;
        this.start = start;
        this.end = end;
//        System.out.println("创建子任务,start:" + start + " end:" + end);
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
//            System.out.println("计算原子任务");
            return computeSequentially();
        }
        // 创建一个子任务为数组的前一半求和
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(number, start, start + length / 2);
        // 利用另一个ForkJoinPool线程异步执行新创建的子任务
        leftTask.fork();

        // 创建一个子任务为数组的后一半求和
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(number, start + length / 2, end);

        // 同时执行第二个子任务，有可能允许进一步递归划分
        final Long rightResult = rightTask.compute();
        // 读取第一个子任务的结果，如果尚未完成就等待
        final Long leftResult = leftTask.join();

        return leftResult + rightResult;
    }

    /**
     * 任务不可分时执行的简单计算方法
     *
     * @return
     */
    private Long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += number[i];
        }
        return sum;
    }

    /**
     * forkJoin计算前n个数的和
     *
     * @param n
     * @return
     */
    public static long forkJoinSum(long n) {
        final long[] numbers = LongStream.rangeClosed(1, n).toArray();
        final ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }

    public static void main(String[] args) {
        System.out.println("SideEffect sum done in:" +
                 measureSumPerf(ForkJoinSumCalculator::forkJoinSum, 10_000_000) + " msecs");

        List<Integer> result = new ArrayList<>();

    }


}
