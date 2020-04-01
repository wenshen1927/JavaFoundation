package _10_._10_7_;

import _10_._10_4_.Contents;
import _10_._10_4_.Destination;

public class Parcel11 {
    private static class ParcelContents implements Contents {
        private int i = 11;
        @Override
        public int value() {
            return i;
        }
    }
    protected static class ParcelDestination implements Destination {
        private String label;
        public ParcelDestination(String whereTo) {
            this.label = whereTo;
        }
        @Override
        public String readLabel() {
            return label;
        }
        // 嵌套内部类里可以有Static修饰的内容
        static int x = 10;
        public static void f() {
        }
        static class AnotherLevel {
            public static void f() {}
            static int i = 10;
        }
    }
    public static Contents contents() {
        return new ParcelContents();
    }
    public static Destination destination(String des) {
        return new ParcelDestination(des);
    }
    public static void main(String[] args) {
        // 声明嵌套内部类不需要外部类的引用
        Contents c = contents();
        Destination des = destination("wuhan");
    }
}
