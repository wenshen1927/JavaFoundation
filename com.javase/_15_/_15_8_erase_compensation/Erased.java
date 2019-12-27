package _15_._15_8_erase_compensation;

/**
 * @Classname Erased
 * @Description
 *由于泛型在运行期就被擦除，那么我们在运行期执行一些对类型参数的操作，就不可实现了
 * @Date 2019/12/27 22:53
 * @Created by Super Man
 */
public class Erased<T> {
    private static final int SIZE=100;

    public static void f(Object arg){
//        if (arg instanceof T){
//            T var = new T();
//            T[] array = new T[SIZE];
//            T[] array = (T) new Object[SIZE];
//        }
    }
}
