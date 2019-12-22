package _7_._7_9_1_init;

/**
 * @author zhangyn
 * @description
 *  这个题考验的是JVM类的加载，有几种方式会触发类初始化，调用常量不会出发类初始化，所以只有JD
 * @date 2019-11-24 21:50
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println(Test3.a);
    }
}

class Test3 {
    public static final String a = "JD";

    static {
        System.out.println("ok");
    }
}
