package _2_behavior_paramlize.function_interface;

import java.util.function.Function;

public class FunctionDemo {
    static int modifyTheValue(int value, Function<Integer,Integer> function) {
        return function.apply(value);
    }

    public static void main(String[] args) {
        int num = 10;

        int res1 = modifyTheValue(num, (x) -> x + 20);
        System.out.println(res1);
    }
}
