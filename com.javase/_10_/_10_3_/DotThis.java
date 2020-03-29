package _10_._10_3_;

/**
 * 如果要生成对外部类对象的引用，可以用外部类名.this
 */
public class DotThis {
    void f() {
        System.out.println("DotThis.f()");
    }

    public class Inner {
        public DotThis outer() {
            // 对外部类对象的引用，可以用外部类名.this
            return DotThis.this;
//            return this;
            // 单纯的this指向的是内部类的this
        }
    }

    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        Inner inner = dt.inner();
        inner.outer().f();
        // 创建内部类对象的时候，内部类对象获取创建它的外部对象的引用.
        System.out.println(inner.outer()); //_10_._10_3_.DotThis@60e53b93
        System.out.println(dt); // _10_._10_3_.DotThis@60e53b93

        // 创建内部类对象 .new 语法
        Inner inner1 = dt.new Inner();
        // 在拥有外部类对象之前是不可能创建内部类对象的，必须使用外部类对象来创建内部类对象
        // 因为内部类对象必须连接到某个外部类对象的上
//        Inner i = new DotThis().Inner();
    }
}
