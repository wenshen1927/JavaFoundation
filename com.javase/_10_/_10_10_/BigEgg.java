package _10_._10_10_;

class Egg {
    private Yolk y;
    protected class Yolk {
        public Yolk() {
            System.out.println("Egg.Yolk()");
        }
    }
    Egg() {
        System.out.println("New Egg()");
        y = new Yolk();
    }
}

/**
 * 子类里有一个和父类相同的内部类，会覆盖掉父类的内部类吗？其实并不会。这两个内部类是两个独立的实体，各有各自的命名空间。
 */
public class BigEgg extends Egg {
    public class Yolk {
        public Yolk() {
            System.out.println("BigEgg.Yolk()");
        }
    }
    public static void main(String[] args) {
        new BigEgg();
    }
}
