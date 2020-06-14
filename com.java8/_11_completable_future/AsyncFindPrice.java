package _11_completable_future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

public class AsyncFindPrice {
    List<Shop> shops = Arrays.asList(new Shop("Best price"),
            new Shop("LetsSaveBig"),
            new Shop("MyvoriteShop"),
            new Shop("buyItAll"),
            new Shop("Like"),
            new Shop("Hate")
    );

    /**
     * 同步的方式查询价格
     * @param product
     * @return
     */
    public List<String> findPrices(String product) {
        return shops.stream()
                .map(shop -> String.format("%s price is %.2s", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    /**
     * 并行流的方式查询价格
     * @param product
     * @return
     */
    public List<String> findPricesWithParallelStream(String product) {
        return shops.parallelStream()
                .map(shop -> String.format("%s price is %.2s", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    /**
     * 异步的方式查询价格
     * @param product
     * @return
     */
    public List<String> findPricesAsync(String product) {
        List<CompletableFuture<String>> priceFuture = shops.stream().map(shop -> CompletableFuture.supplyAsync(
                () -> shop.getName() + " price is " + shop.getPrice(product)
        )).collect(Collectors.toList());

        return priceFuture.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    /**
     * 异步的方式查询价格,加入指定线程池
     * @param product
     * @return
     */
    public List<String> findPricesAsyncExecutor(String product) {
        List<CompletableFuture<String>> priceFuture = shops.stream().map(shop -> CompletableFuture.supplyAsync(
                () -> shop.getName() + " price is " + shop.getPrice(product),executor
        )).collect(Collectors.toList());

        return priceFuture.stream()
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
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println("Available Processors :" + i);

        AsyncFindPrice asyncFind = new AsyncFindPrice();
        long start = System.nanoTime();

        // 同步执行
        List<String> myPhone27s = asyncFind.findPrices("myPhone27s");
        System.out.println(myPhone27s);
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + "msec");
        System.out.println("============");

        // 并行流
        List<String> myPhone27s1 = asyncFind.findPricesWithParallelStream("myPhone27s");
        System.out.println(myPhone27s1);
        long duration1 = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + (duration1-duration) + "msec");
        System.out.println("============");

        // 异步执行
        List<String> myPhone27s2 = asyncFind.findPricesAsync("myPhone27s");
        System.out.println(myPhone27s2);
        long duration2 = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + (duration2 -duration1)+ "msec");
        System.out.println("============");

    }
}
