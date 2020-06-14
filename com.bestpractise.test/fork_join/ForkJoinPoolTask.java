package fork_join;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class ForkJoinPoolTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] arr = new int[100];
        Random random = new Random();
        int total = 0;
        // 初始化数组
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(47);
            total += arr[i];
        }

        System.out.println("初始化数组总合:" + total);

        SumTask task = new SumTask(arr, 0, arr.length);
        // 创建一个通用池，jdk1.8提供的功能
        ForkJoinPool pool = ForkJoinPool.commonPool();
        // 提交待分解的任务
        ForkJoinTask<Integer> future = pool.submit(task);
        System.out.println("多线程执行结果：" + future.get());
        pool.shutdown();
    }
}
