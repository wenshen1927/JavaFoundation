package _10_._10_8_._10_8_1_;

/**
 * 闭包与回调
 */
public class Callbacks {
    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);
        // 传入中间函数caller一个回调函数（注册回调函数），
        // 当系统库决定执行该类动作的时候（go），会执行传入的回调函数的动作，并且操作传入回调函数的值
        // 把回调函数像参数一样传入另一个函数（事实上是传递一个仅能执行回调函数的内部类对象（回调对象）（hook 钩子），很安全）
        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackReference());// 回调函数带上了其外部对象的属性值,i=1
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
}
interface Incrementable {
    void increment();
}
/**
 * 外部类实现接口
 */
class Callee1 implements Incrementable {
    private int i = 0;

    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}
class MyIncrement implements Incrementable {

    @Override
    public void increment() {
        System.out.println("Other operation");
    }

    static void f(MyIncrement mi) {
        mi.increment();
    }
}
/**
 * 类继承实现increment()
 */
class Callee2 extends MyIncrement {
    private int i = 0;
    // 外部类已经实现了increment()，并且与期望的继承接口的increment()功能不同
    // 如果想再实现一种increment的功能，必须使用内部类
    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }
    /**
     * 内部类实现接口
     */
    private class Closure implements Incrementable {
        @Override
        public void increment() {
//            this.increment();
            Callee2.this.increment();
        }
    }
    Incrementable getCallbackReference() {
        return new Closure();
    }
}
class Caller {
    private Incrementable callbackReference;
    Caller(Incrementable cbh) {
        this.callbackReference = cbh;
    }
    void go() {
        callbackReference.increment();
    }
}
