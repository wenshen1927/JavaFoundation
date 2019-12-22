package three;

/**
 * @author zhangyn
 * @description
 * @date 2019/6/28 下午1:50
 */
public class BaseClass {
    private int baseName;

    public BaseClass() {
        baseName = 1;
        System.out.println("base class" + baseName);
    }

}

class InheritClass {
    public int baseName;

    public InheritClass() {
        System.out.println("non param");
    }

    public InheritClass(int baseName) {
        System.out.println("param");
    }

    public static void main(String[] args) {
        InheritClass ic = new InheritClass(20);
        System.out.println("Inherit class " + ic.baseName);
    }


}
