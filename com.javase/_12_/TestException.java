package _12_;

/**
 * @author zhangyn
 * @date 2018/11/23 上午10:39
 */
public class TestException {
    public static int f(int n) {
        try {
            int r = n * n;
            return r;
        } finally {
            if (n == 2) {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(f(2));
    }
}
