package thread_pool;

public class Task implements Runnable {
    @Override
    public void run() {
        try {
            // 如果不sleep的话，时间片非常短
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+ " running");
    }
}
