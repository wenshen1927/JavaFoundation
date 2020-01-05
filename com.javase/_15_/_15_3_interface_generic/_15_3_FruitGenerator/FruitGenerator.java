package _15_._15_3_interface_generic._15_3_FruitGenerator;

import _15_._15_3_interface_generic._15_3_generator.Generator;

/**
 * @Classname FruitGenerator
 * @Description TODO
 * @Date 2020/1/2 23:32
 * @Created by Super Man
 */
// 未传入泛型实参时，与泛型类的定义相同，在声明类的时候，需将泛型的声明也一起加到类中
//  如果类不声明泛型，如下，编译器会报错
//class FruitGenerator implements Generator<T> {
//}
public class FruitGenerator<T> implements Generator<T> {
    @Override
    public T next() {
        return null;
    }
}
