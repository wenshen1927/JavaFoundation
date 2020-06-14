package thread_pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        System.out.println(System.currentTimeMillis());
        scheduledExecutorService.schedule(()->{
            System.out.println("延迟3秒执行");
            System.out.println(System.currentTimeMillis());
        },3, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }
}
