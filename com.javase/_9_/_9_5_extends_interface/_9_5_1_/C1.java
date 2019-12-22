package _9_._9_5_extends_interface._9_5_1_;

/**
 * @author zhangyn
 * @description
 * @date 2019-12-08 22:19
 */
interface I1 {
    void f();
}
interface I2 {
    int f(int i);
}
interface I3 {
    int f();
}
public class C1  {
    public int f(){
        return 1;
    }
}
class C2 implements I1,I2{

    @Override
    public void f() {

    }

    @Override
    public int f(int i) { // 重载
        return 0;
    }
}

class C3 extends C1 implements I2 {

    @Override
    public int f(int i) { // 和继承来的f()重载
        return 0;
    }
}
class C4 extends C1 implements I3 {
    @Override
    public int f(){  // C1的方法和I3的方法一样
        return 0;
    }
}
//class C5 extends C1 implements I1,I3{
//
//}
