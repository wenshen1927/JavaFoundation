package _10_._10_7_;

public class MultiNestingAccess {
    public static void main(String[] args) {
        NMA nma = new NMA();
        NMA.A nmaa = nma.new A();
        NMA.A.B nmaab  = nmaa.new B();
        nmaab.h();
    }
}

class NMA {
    private void f() {
    }

    class A {
        private void g() {
        }

        public class B {
            // 这里内部类可以直接访问外部类的方法，即使他们是private的，
            // 因为内部类对象一定会保留一个指向外部类的引用
            void h() {
                f();
                g();
            }
        }
    }
}