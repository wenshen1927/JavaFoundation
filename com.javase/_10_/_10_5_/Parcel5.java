package _10_._10_5_;

import _10_._10_4_.Destination;
import _10_._10_4_.Parcel4;

/**
 * 在方法内部定义的类，局部内部类
 */
public class Parcel5 {
    public Destination destination(String s) {
        class PDestination implements Destination {
            private String label;

            public PDestination(String label) {
                this.label = label;
            }

            @Override
            public String readLabel() {
                return label;
            }
        }
        return new PDestination(s); // 每次调用这个方法都要创建一个新的类对象？
    }


    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination destination = p.destination("wuhan");
    }
}
