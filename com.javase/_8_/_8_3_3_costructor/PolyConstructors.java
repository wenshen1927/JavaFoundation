package _8_._8_3_3_costructor;

/**
 * @author zhangyn
 * @description
 * 在父类构造器里，调用一个子类重写的方法会怎样？
 * 有可能会出错，无法按照逻辑初始化，而且很难排查
 * @date 2019-11-26 23:32
 */
public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5,"bb");
    }
}

class Glyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }

    Glyph() {
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;

    private String str = "aa";

    @Override
    void draw() {
        System.out.println("RoundGlyph.draw() , radius = " + radius + " str = " + str);
    }

    RoundGlyph(int r, String s) {
        this.radius = r;
        this.str = s;
        System.out.println("RoundGlyph() , radius = " + radius  + " str = " + str);
    }
}

