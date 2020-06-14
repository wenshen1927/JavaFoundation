package _11_completable_future;

/**
 * 模拟延迟
 */
public class SimulateUtil {
    /**
     * 模拟耗时方法
     */
    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
