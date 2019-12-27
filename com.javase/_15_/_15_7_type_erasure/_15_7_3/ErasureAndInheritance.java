package _15_._15_7_type_erasure._15_7_3;

/**
 * @Classname GenericBase
 * @Description TODO
 * @Date 2019/12/25 23:34
 * @Created by Super Man
 */
class GenericBase<T> {
    private T element;

    public void set(T arg) {
        arg = element;
    }

    public T get() {
        return element;
    }
}
class Derived1<T> extends GenericBase<T> {
}

/**
 * 不适用泛型
 */
class Derived2 extends GenericBase {}
/**
 * no wildcard excepted
 * Derived3 产生的错误意味着编译器期望得到一个原生基类
 */
//class Derived3 extends GenericBase<?> {}

public class ErasureAndInheritance {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Derived2 d2 =  new Derived2();
        Object object = d2.get();
        // 这里会有警告：为什么要有警告？警告你没有使用泛型，但是调用的方法传入了一个参数，这个参数是用泛型参数定义的。对代码运行没什么影响。
        d2.set(object);
    }
}
