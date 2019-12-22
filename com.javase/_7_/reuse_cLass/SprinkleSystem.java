package _7_.reuse_cLass;

/**
 * 类的组合
 */
public class SprinkleSystem {
    private String value1, value2, value3;
    private WaterSource waterSource = new WaterSource();
    private int i;
    private float f;

    @Override
    public String toString() {
        return " value1" + value1 +
                " value2" + value2 +
                " value3" + value3 +
                " i" + i +
                " f" + f +
                " source " + waterSource;
    }

    public static void main(String[] args) {
        SprinkleSystem ss = new SprinkleSystem();
        System.out.println(ss);
    }

}

class WaterSource {
    private String s;

    WaterSource() {
        System.out.println(s);
        System.out.println("WaterSource()");
        s = "Constructor";
    }

    public String toString() {
        return s;
    }
}
