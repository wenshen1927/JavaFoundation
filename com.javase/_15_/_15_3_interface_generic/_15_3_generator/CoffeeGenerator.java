package _15_._15_3_interface_generic._15_3_generator;

import java.util.Iterator;
import java.util.Random;

/**
 * @author zhangyn
 * @description 随机生成不同类型的Coffee对象
 * @date 2019-12-14 21:17
 */
public class CoffeeGenerator<T> implements Generator<Coffee>, Iterable<Coffee> {

    private Class[] types = {Lattte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class};

    private static Random rand = new Random(47);

    public CoffeeGenerator() {
    }

    private int size = 0;

    public CoffeeGenerator(int size) {
        this.size = size;
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        /**
         * 在使用迭代器遍历的时候，不允许增删容器如list
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
        // 只有实现看Iterable接口才能使用foreach,foreach 相当于调用了hasNext()方法
        for (Coffee c :
                new CoffeeGenerator<>(5)) {
            System.out.println(c);

        }
        CoffeeGenerator<Object> coffees = new CoffeeGenerator<>(5);
        Iterator<Coffee> iterator = coffees.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
