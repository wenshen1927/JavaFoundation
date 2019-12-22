package _15_._15_3_interface_generic._15_3_fibonacci;

import _15_._15_3_interface_generic._15_3_generator.Generator;

/**
 * @author zhangyn
 * @description
 * @date 2019-12-14 22:02
 */
public class Fibonacci implements Generator<Integer> {
    private int count = 0;

    @Override
    public Integer next() {
        return fib(count++);
    }

    private int fib(int n) {
        if (n < 2) {
            return 1;
        }
        return fib(n - 2) + fib(n - 1);
    }

    public static void main(String[] args) {
        Fibonacci gen = new Fibonacci();
        for (int i = 0; i < 1000; i++) {
            System.out.println(gen.next());
        }
    }

}
