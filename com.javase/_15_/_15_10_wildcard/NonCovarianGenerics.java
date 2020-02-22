package _15_._15_10_wildcard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyn
 * @description
 *
 * @date 2020-01-12 23:56
 */
public class NonCovarianGenerics {
    public static void main(String[] args) {
        // 1、编译错误，List和数组的作用一样，但是
//    List<Fruit> flist = new ArrayList<Apple>();
        // 2、编译没有错误，运行时可能出错
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
//        fruits[1] = new Fruit(); //运行时报错
        List<? super Fruit> list1= new  ArrayList<>();
        list1.add(new Apple());
        list1.add(new Orange());
        Object object = list1.get(0);
//        Fruit object1 = list1.get(1);
    }
}
