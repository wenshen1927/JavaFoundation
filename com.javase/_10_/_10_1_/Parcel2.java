package _10_._10_1_;


public class Parcel2 {
    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        Destination(String whereto) {
            label = whereto;
        }

        String readLabel() {
            return label;
        }
    }
    // 这是一种典型做法，外部类提供一个指向内部类的引用
    public Contents contents() {
        return new Contents();
    }

    public Destination to(String s) {
        return new Destination(s);
    }

    public void ship(String dest) {
        Contents c = contents();
        Destination d = to(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcel2 p = new Parcel2();
        p.ship("wuhan");
        Parcel2 q = new Parcel2();
        Parcel2.Contents contents = q.contents();
    }
}
