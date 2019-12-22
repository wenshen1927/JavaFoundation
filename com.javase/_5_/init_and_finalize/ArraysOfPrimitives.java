package _5_.init_and_finalize;

/**
 * @author zhangyn
 * @date 2018/10/25 下午4:14
 */
public class ArraysOfPrimitives {
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2;
        a2 = a1;
        System.out.println(a1);
        System.out.println(a2);
        for (int i = 0; i < a2.length; i++) {
            a2[i] = a2[i] + 1;
        }
        for (int i = 0; i < a1.length; i++) {
            System.out.print("a1[" + i + "]=" + a1[i] + " ");
        }
    }
}
