package _10_._10_3_;

public class StaticInnerClass {
    static class Inner {
        public static Inner inner() {
            return new Inner();
        }
    }

    public static void main(String[] args) {
        Inner inner = Inner.inner();
        Inner a = new Inner();
    }
}
