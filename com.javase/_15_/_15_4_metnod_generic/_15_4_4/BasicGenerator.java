package _15_._15_4_metnod_generic._15_4_4;

import _15_._15_3_interface_generic._15_3_generator.Generator;

/**
 * @author zhangyn
 * @description
 * 生成器：
 * 传入任意一个类的类对象，生成器可以生成该类的对象
 * @date 2019-12-15 23:22
 */
public class BasicGenerator<T> implements Generator<T> {
    private Class<T> type;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T next() {
        try {
            return this.type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> Generator<T> creat(Class<T> type){
        return new BasicGenerator<>(type);
    }
}
