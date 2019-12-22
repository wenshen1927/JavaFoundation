package _9_._9_1_abstract;

/**
 * @author zhangyn
 * @description 抽象类与抽象方法
 * @date 2019-12-01 23:38
 */
public class AbstractClass {
    /**
     * 抽象类是不完整的类，当我们试图创建一个抽象类时，需要完整地实现它的所有抽象方法。
     */
    AbstractBaseClass abstractClass = new AbstractBaseClass() {
        @Override
        void abstractMethod() {

        }
    };
    // 这里会编译报错,因为抽象类不希望自己被实例化
//    AbstractBaseClassWithoutAbstractMethod a = new AbstractBaseClassWithoutAbstractMethod();


}

/**
 * 抽象基类
 */
abstract class AbstractBaseClass {
    abstract void abstractMethod();
}

/**
 * 不含抽象方法的抽象类
 */
abstract class AbstractBaseClassWithoutAbstractMethod {
    public void m1(){
        System.out.println("method 1");
    }
}
