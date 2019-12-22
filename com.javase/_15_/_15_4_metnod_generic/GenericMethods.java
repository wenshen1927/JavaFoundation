package _15_._15_4_metnod_generic;

/**
 * @author zhangyn
 * @description
 * @date 2019-12-14 23:27
 */
public class GenericMethods {
    /**
     * 泛型方法：在返回值之前声明一个参数类型<T> 就表示这是泛型方法
     */
    public <T> void f(T t) {
        System.out.println(t.getClass().getSimpleName());
    }

    public <T, K, V> void f1(T t, K k, V v) {
        System.out.println(t.getClass().getSimpleName());
        System.out.println(k.getClass().getSimpleName());
        System.out.println(v.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        /**在调用泛型方法的时候，通常不指定参数类型，而是像调用普通方法一样，编译器会做类型参数推断*/
        gm.f(" ");
        gm.f(new Integer(12));
        gm.f(1);
        gm.f(1.1);
        gm.f('c');
        gm.f(gm);
        System.out.println(" ========  ");
        gm.f1("",2,gm);
    }
}
