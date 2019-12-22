package _8_._8_2_Super;

/**
 * @author zhangyn
 * @description
 * 多态：只有普通调用的方法调用可以是多态的，
 * 对于域变量的访问不会体现多态（静态方法也没有多态性）
 * @date 2019-11-24 16:16
 */
public class FieldAccess {
    public static void main(String[] args) {
        // 父类对象
        Super sup = new Sub();
        System.out.println("sup.field :" + sup.field +
                "  sup.getField():" + sup.getField());
        // 子类对象
        Sub sub = new Sub();
        System.out.println("sub.field :" + sub.field +
                "  sub.getField():" + sub.getField());
        System.out.println("sub.getSuperField:" + sub.getSuperField() +
                " sub.supGetField:" + sub.supGetField());
    }
}

class Super {
    public int field = 0;

    public int getField() {
        return this.field;
    }
}

class Sub extends Super {
    public int field = 1;

    @Override
    public int getField() {
        return field;
    }

    public int getSuperField() {
        return super.field;
    }

    public int supGetField() {
        return super.getField();
    }
}
