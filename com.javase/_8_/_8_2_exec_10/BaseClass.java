package _8_._8_2_exec_10;

/**
 * @author zhangyn
 * @description
 * @date 2019-11-17 21:23
 */
public class BaseClass {
    public void method1() {
        this.method2();
    }

    public void method2() {
        System.out.println("base class method 2");
    }

    public static void main(String[] args) {
        BaseClass bc = new BaseClass();
        bc.method1();
        ChildClass cc = new ChildClass();
        cc.method1();
    }
}

class ChildClass extends BaseClass {
    @Override
    public void method2() {
        System.out.println("child class method 2");
    }
}
