package _15_._15_3_interface_generic._15_3_fibonacci;

import _15_._15_3_interface_generic._15_3_fibonacci.Fibonacci;

import java.util.Iterator;

/**
 * @author zhangyn
 * @description
 * @date 2019-12-14 22:10
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {

    private int n;

    public IterableFibonacci(int count) {
        this.n = count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for (int i :
                new IterableFibonacci(15)) {
            System.out.println(i);
        }
    }

}
