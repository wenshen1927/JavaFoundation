package _10_._10_1_;

/**
 * 练习1、练习3
 */
public class Outer {
    private String outerString = "Hello World!";

    public Outer(String outerString) {
        this.outerString = outerString;
    }

    class Inner {
        public String toString() {
            return outerString;
        }
    }

    Inner getInner() {
        return new Inner();
    }

    public static void main(String[] args) {
        Outer outer = new Outer("How do you do");
        Outer.Inner inner = outer.getInner();
        Inner inner1 = outer.getInner();
        System.out.println(inner.toString());
    }
}
