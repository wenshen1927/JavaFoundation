package _15_._15_5_innerclass;

import _15_._15_3_interface_generic._15_3_generator.Generator;
import _15_._15_4_metnod_generic._15_4_3.Generators;

import java.util.*;

/**
 * @author zhangyn
 * @description
 * @date 2019-12-22 00:26
 */
public class BankTeller {
    public static void serve(Teller teller, Customer customer) {
        System.out.println(teller + " serve " + customer);
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        Queue<Customer> line = new LinkedList<>();
        Generators.fill(line, Customer.generator(), 16);
        List<Teller> tellers = new ArrayList<>(3);
        Generators.fill(tellers, Teller.generator(), 3);
        for (Customer customer : line) {
            serve(tellers.get(random.nextInt(tellers.size())), customer);
        }
    }
}

class Customer {
    private static long count = 1;
    /**
     * 对象id
     */
    private final long id = count++;

    private Customer() {
    }

    @Override
    public String toString() {
        return "Customer : " + id;
    }

    /**
     * 生成器函数
     *
     * @return
     */
    static Generator<Customer> generator() {
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }
}

class Teller {
    private static long count = 1;
    private final long id = count++;

    private Teller() {
    }

    @Override
    public String toString() {
        return "Teller : " + id;
    }

    static Generator<Teller> generator() {
        return new Generator<Teller>() {
            @Override
            public Teller next() {
                return new Teller();
            }
        };
    }
}