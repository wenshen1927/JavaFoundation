package _15_._15_3_interface_generic._15_3_generator;

/**
 * @author zhangyn
 * @description
 * @date 2019-12-14 21:13
 */
public class Coffee {
    /**在第一次被加载的时候，存储到静态常量池里，且被初始化为0，并且只有这一次初始化*/
    private static long counter = 0;
    /**引用计数，每次生成一个对象的时候，counter这个变量都会在初始化的时候自动+1*/
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

class Lattte extends Coffee {
}

class Mocha extends Coffee {
}

class Cappuccino extends Coffee {
}

class Americano extends Coffee {
}

class Breve extends Coffee {
}

