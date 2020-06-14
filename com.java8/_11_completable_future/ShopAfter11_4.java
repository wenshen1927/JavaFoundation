package _11_completable_future;

import java.util.Random;

/**
 * 11.4节之后的Shop类
 */
public class ShopAfter11_4 {
    String name;

    public ShopAfter11_4(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShopAfter11_4(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        ShopAfter11_4 shop = new ShopAfter11_4("Best Restrount");
        String price = shop.getPrice(shop.getName());
        System.out.println(price);
    }

    public String getPrice(String product) {
        double price = calculatePrice(product);
        Random random = new Random(47);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s",name,price,code);
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
