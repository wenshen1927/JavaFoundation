package _5_.init_and_finalize;

/**
 * @author zhangyn
 * @date 2018/10/25 下午4:49
 */
public class VarargType {
    static void f(Character... arg) {
        System.out.println(arg.getClass());
        System.out.println("length" + arg.length);
    }

    static void g(int... arg) {
        System.out.println(arg.getClass());
        System.out.println("length" + arg.length);
    }

    public static void main(String[] args) {
        f('a');
        f();
        g(1);
        g();
    }
}
