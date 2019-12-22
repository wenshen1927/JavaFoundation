package _15_._15_4_metnod_generic._15_4_4;

import _15_._15_3_interface_generic._15_3_generator.Generator;

/**
 * @author zhangyn
 * @description
 * @date 2019-12-15 23:30
 */
public class BasicGeneratorDemo {
    public static void main(String[] args) {
        Generator<CountObject> gen = BasicGenerator.creat(CountObject.class);
//        CountObject next = gen.next();
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }

        BasicGenerator<CountObject> basicGenerator = new BasicGenerator(CountObject.class);

        CountObject next = basicGenerator.next();
        System.out.println(next);
    }
}
