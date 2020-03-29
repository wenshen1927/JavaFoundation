package _10_._10_6_;

public class AnonymousConstructor {
    // 这里并不要求i是final的，因为getBase方法里没有使用到这个变量`
    public static Base getBase(int i) {
        {
            System.out.println("Inside instance initializer");
        }
        return new Base(i) {
            @Override
            public void f() {
                System.out.println("In anonymous f()");
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase(47);
        base.f();
    }
}

abstract class Base {
    public Base(int i) {
        System.out.println("Base constructor.i = "+i);
    }

    public abstract void f();
}
