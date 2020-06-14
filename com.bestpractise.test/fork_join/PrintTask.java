package fork_join;

import java.io.PrintWriter;
import java.util.concurrent.RecursiveAction;

public class PrintTask extends RecursiveAction {

    /**
     * 最多打印50个数
     */
    private static final int THRESHOLD = 50;
    private int start;
    private int end;

    public PrintTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if ((end - start) < THRESHOLD) {
            // 若待打印的值的个数小于阈值，则打印
            for (int i = start; i < end; i++) {
                System.out.println(Thread.currentThread().getName() + "的i值:"+i);
            }
        } else {
            // 否则切分任务
            int middle = (start + end) / 2;
            PrintTask left = new PrintTask(start, middle);
            PrintTask right = new PrintTask(middle, end);
            left.fork();
            right.fork();
        }
    }
}
