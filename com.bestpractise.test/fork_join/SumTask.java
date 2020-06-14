package fork_join;


import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 20;
    private int[] array;
    private int start;
    private int end;

    public SumTask(int[] array, int start, int end) {
        super();
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if (end - start < THRESHOLD) {
            for (int i = start; i < end; i++) {
                System.out.println(Thread.currentThread().getName() + "的i值" + array[i]);
                sum += array[i];
            }
            return sum;
        } else {
            int middle = (start + end) / 2;
            SumTask left = new SumTask(array, start, middle);
            SumTask right = new SumTask(array, middle, end);

            // 并行执行2个小任务
            left.fork();
            right.fork();
            // 把两个小任务累加的结果合并起来
            return left.join() + right.join();
        }
    }
}
