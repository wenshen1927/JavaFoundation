package _10_._10_6_;


import _10_._10_4_.Destination;

public class Parcel9 {
    // 定义一个匿名内部类，如果希望它使用一个在其外部定义的对象，编译器会要求其参数引用是final。
    // 在java8中去掉了这个限制，但是还是加上好,作为一种暗示
    public Destination destination(final String dest) {
        return new Destination() {
            private String label = dest;
            @Override
            public String readLabel() {
                return label;
            }
        };
    }
    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("WuHan");
    }
}
