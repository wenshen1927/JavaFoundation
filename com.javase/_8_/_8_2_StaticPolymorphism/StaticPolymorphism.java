package _8_._8_2_StaticPolymorphism;

/**
 * @author zhangyn
 * @description 静态方法是没有多态性的
 * @date 2019-11-24 19:11
 */
public class StaticPolymorphism {
    public static void main(String[] args) {
        StaticSuper staticSuper = new StaticSub();
        System.out.println(StaticSuper.staticGet());
        System.out.println(staticSuper.dynamicGet());
    }
}

class StaticSuper {
    public static String staticGet() {
        return "Base staticGet()";
    }

    public String dynamicGet() {
        return "Base dynamicGet()";
    }
}

class StaticSub extends StaticSuper {
    public static String staticGet() {
        return "sub staticGet()";
    }

    @Override
    public String dynamicGet() {
        return "sub dynamicGet()";
    }
}