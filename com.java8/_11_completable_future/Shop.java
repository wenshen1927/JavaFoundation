package _11_completable_future;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Shop {

    String name;

    public Shop(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shop(String name) {
        this.name = name;
    }


    /**
     * v1 11.4节之前的代码
     * [同步方式]根据商品名称，返回价格
     * @param product
     * @return
     */
    public double getPrice(String product) {
        // 可能会有很多耗时的操作，比如查询其供应商信息或者调用其他外部接口，或者查询数据库
        return calculatePrice(product);
    }

    /**
     * [异步方式]根据商品名称，返回价格
     * @param product
     * @return
     */
    public Future<Double> getPriceAsync(String product) {
        // 创建CompletableFuture对象，它会包含计算结果
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        // 在另一个线程中以异步方式执行计算
        new Thread( () -> {
            try {
                double price = calculatePrice(product);
                // 耗时的任务计算完毕，并且将结果设置到Future的返回值
                futurePrice.complete(price);// 计算结果出来，调用complete方法，结束CompletableFuture对象的运行，并设置返回值
            }catch (Exception e) {
                // 如果异步线程里有异常，将其失败的异常抛出
                futurePrice.completeExceptionally(e);
            }
        }).start();
        // 无需等待耗时的操作，直接返回future实例
        return futurePrice;
    }

    /**
     * getPriceAsync的工厂方法版，更加简洁
     * @param product
     * @return
     */
    public Future<Double> getPriceAsyncWithSupply(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    public static void main(String[] args) {
        Shop shop = new Shop("ZhuFu");
        long start = System.nanoTime();
        String product = "My Favorite Product";
        // 第一个耗时查询操作
        Future<Double> futurePrice = shop.getPriceAsync(product);
        long invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Invocation returned after "+invocationTime + "msecs");
        // 第二个耗时查询操作
        Future<Double> futurePrice1 = shop.getPriceAsync(product);
        long invocationTime1 = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Invocation returned after "+invocationTime1 + "msecs");

        // 执行其他操作，比如查询其他商店
        shop.doSomeThingElse(product);
        long callAnotherMethod = (System.nanoTime() - start) / 1_000_000;
        System.out.println("call another method after "+callAnotherMethod + "msecs");

        // 在计算商品价格的同事，从future对象中读取价格，如果价格未知，或发生阻塞
        try {
            double price = futurePrice.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long retrievalTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Price returned after "+retrievalTime + "msecs");
        // 另一个异步操作返回值
        try {
            double price1 = futurePrice1.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long retrievalTime1 = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Price1 returned after "+retrievalTime1 + "msecs");

    }

    private void doSomeThingElse(String product) {
        getAnotherPrice(product);
    }

    private void getAnotherPrice(String product) {
        delay();
    }

    /**
     * 计算价格，随机返回一个数
     * @param product
     * @return
     */
    private double calculatePrice(String product) {
        delay();
        Random random = new Random(0);
//        if (true) {
//            throw new RuntimeException("product not available");
//        }
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

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
