package _8_._8_5_2_RTTI;

/**
 * @author zhangyn
 * @description 运行时类相关识别
 * @date 2019-12-01 00:50
 */
public class RTTI {
    public static void main(String[] args) {
        Useful[] x = {
                new Useful(),
                new MoreUseful()
        };
        x[0].f();
        x[1].g();
        // 编译期报错
//        x[1].u();
        ((MoreUseful) x[1]).u(); // 向下转型
        ((MoreUseful) x[0]).u(); // 编译期没有问题，但是运行时会抛异常 ClasCastException
    }
}

class Useful {
    public void f() {
    }

    public void g() {
    }
}

class MoreUseful extends Useful {
    @Override
    public void f() {
    }

    @Override
    public void g() {
    }

    public void u() {
    }

    public void v() {
    }

    public void w() {
    }
}
