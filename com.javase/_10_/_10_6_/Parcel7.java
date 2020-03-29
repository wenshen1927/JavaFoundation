package _10_._10_6_;

import _10_._10_4_.Contents;

/**
 * 匿名内部类：创建一个继承自父类或接口的类对象
 */
public class Parcel7 {
    public Contents contents() {
        return new Contents() {
            private int i = 11;

            @Override
            public int value() {
                return i;
            }
        };
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents contents = p.contents();
    }
}
