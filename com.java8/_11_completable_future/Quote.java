package _11_completable_future;

public class Quote {
    private final String shopName;

    private final double price;

    private final Discount.Code discountCode;

    public Quote(String shopName,double price,Discount.Code discountCode) {
        this.shopName = shopName;
        this.price = price;
        this.discountCode = discountCode;
    }

    /**
     * 静态工厂方法，返回一个Quote类对象
     * @param s
     * @return
     */
    public static Quote parse(String s) {
        String[] split = s.split(":");
        String shopName = split[0];
        double price = Double.parseDouble(split[1]);
        Discount.Code code = Discount.Code.valueOf(split[2]);
        return new Quote(shopName,price,code);
    }

    public String getShopName() {
        return shopName;
    }

    public double getPrice() {
        return price;
    }

    public Discount.Code getDiscountCode() {
        return discountCode;
    }
}
