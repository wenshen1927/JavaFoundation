package _5_.init_and_finalize;

/**
 * @author zhangyn
 * @date 2018/10/25 下午4:42
 */
public class NewVarArgs {
    static void printArray(Object... obj) {
        for (Object o :
                obj) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printArray(1, 2, 3, new NewVarArgs(), 0.0);//可变参数能够识别任意个参数
        printArray((Object[]) new Integer[]{1, 2, 3, 4});//可以识别一个数组
        printArray();//可以不传任何参数
    }
}
