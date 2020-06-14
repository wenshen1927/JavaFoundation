package fork_join;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkerStealingPool {

    public static void main(String[] args) {
        // 创建一个并行级别的线程池，并行级别决定了同一时刻最多有多少个线程在执行，如不传并行级别参数，将默认为当前系统的CPU个数
        // 设置并行级别为2，即默认每时每刻只有2个线程同时执行
        ExecutorService executorService = Executors.newWorkStealingPool(8);

        for (int i = 0; i <= 10; i++) {
            final int count = i;
            executorService.submit(() -> {
                Date now = new Date();
                System.out.println("线程" + Thread.currentThread() + "完成任务：" +
                        count + " 时间为：" + now.getSeconds());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        while (true){
            // 必须死循环才能看到效果
        }
    }
}
