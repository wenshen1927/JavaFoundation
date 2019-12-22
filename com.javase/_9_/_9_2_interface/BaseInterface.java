package _9_._9_2_interface;

/**
 * @author zhangyn
 * @description
 * @date 2019-12-02 00:02
 */
public interface BaseInterface {
    /**
     * static 和 final 隐式修饰，编译期常量
     */
    int i = 0;

    /**
     * 默认 public修饰
     */
    void method1();

    void method2();
}

//class ImpleamentClass implements BaseInterface {
//
//    public void getI() {
//        System.out.println(BaseInterface.i);
//    }
//
//    /**
//     * 编译器会报错，因为方法的访问权限降低了
//     */
//    @Override
//    void method1() {
//        System.out.println("非public的实现方法");
//    }
//
//    /**
//     * 编译器不会报错，因为声明为public了。实现类必须实现接口的所有方法。
//     */
//    @Override
//    public void method2() {
//
//    }
//}

/**
 * 抽象类继承接口,可以继承接口的方法的声明，且必须声明为抽象的。
 */
abstract class AbstractClassImplementInterface implements BaseInterface {
    @Override
    public abstract void method1();

    @Override
    public void method2() {

    }
}
