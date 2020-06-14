package _2_behavior_paramlize;

import _1_feature.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();

        inventory.add(new Apple("green",20D));
        inventory.add(new Apple("red",20D));
        inventory.add(new Apple("red",10D));
        inventory.add(new Apple("green",10D));
        inventory.add(new Apple("green",5D));

        // 1 比较器
        inventory.sort(
                (Apple apple1,Apple apple2)-> apple1.getWeight().compareTo(apple2.getWeight()));
        // 方法引用
        inventory.sort(Comparator.comparing(Apple::getColor));

        // 2 runnable实现新线程
        Thread t = new Thread(() -> System.out.println("Hello , world"));
        t.start();

//        () -> 42;
//        （Apple a）-> {
//            System.out.println("hello");
//            System.out.println("world");
//        }



    }
}
