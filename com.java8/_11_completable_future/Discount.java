package _11_completable_future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

/**
 * 折扣服务，是一个远程服务，要模拟延迟
 */
public class Discount {
    public enum Code {
        NONE(0),SILVER(5),GOLD(10),PLATINUM(15),DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    List<ShopAfter11_4> shops = Arrays.asList(new ShopAfter11_4("Best price"),
            new ShopAfter11_4("LetsSaveBig"),
            new ShopAfter11_4("MyvoriteShop"),
            new ShopAfter11_4("buyItAll"),
            new ShopAfter11_4("Like"),
            new ShopAfter11_4("Hate")
    );

    /**
     * 返回折扣信息
     * @param quote
     * @return
     */
    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + " price is "+apply(quote.getPrice(),quote.getDiscountCode());
    }

    /**
     * 计算折扣
     * @param price
     * @param code
     * @return
     */
    public static double apply(double price,Code code) {
        SimulateUtil.delay();
        return price * (100 - code.percentage) / 100;
    }

    public List<String> findPrices(String product) {
        return shops.stream().map(shop -> shop.getPrice(product))
                .map(Quote::parse)// 解析price字符串，转换为Quote对象
                .map(Discount::applyDiscount) // 将转换后的Quote对象进行折后计算
                .collect(Collectors.toList());
    }

    public List<String> findPricesAsync(String product) {
        List<CompletableFuture<String>> priceFuture = shops.stream()
                // 耗时操作，异步 获取原始价格的操作比较耗时，异步操作
                .map(shopAfter11_4 -> CompletableFuture.supplyAsync(() -> shopAfter11_4.getPrice(product), executor))
                // 不耗时，同步 Quote对象存在的时候，对其返回值进行转换
                .map(future -> future.thenApply(Quote::parse))
                // 耗时操作，异步 使用另外一个异步任务，申请折扣，也是一个耗时的任务
                .map(future -> future.thenComposeAsync(quote -> CompletableFuture.supplyAsync(
                        () -> Discount.applyDiscount(quote), executor
                )))
                .collect(Collectors.toList());

        return priceFuture.stream()
                // 等待流中的所有future执行完毕，提取各自的返回值，返回值之间没有依赖
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    private final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t =new Thread(r);
            // 设置守护线程，这样不会阻止程序的关停
            t.setDaemon(true);
            return t;
        }
    });

    public static void main(String[] args) {
        Discount d = new Discount();
        long start = System.nanoTime();
        List<String> list = d.findPrices("aaa");
        System.out.println(list);
        long invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Sync method after "+invocationTime + "msecs");

        long start1 = System.nanoTime();
        List<String> list1 = d.findPricesAsync("aaa");
        System.out.println(list1);
        long invocationTime1 = (System.nanoTime() - start1) / 1_000_000;
        System.out.println("Async method after "+invocationTime1 + "msecs");
    }
}
