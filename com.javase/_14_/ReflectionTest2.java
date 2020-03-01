package _14_;

import java.lang.annotation.ElementType;

public class ReflectionTest2 {
    public static void main(String[] args) {
        Class c1 = MyAnno.class; // 注解
        Class c2 = Integer.class; // 类
        Class c3 = AnnotionReflaction.class; // 类
        Class c4 = Object.class; // 类
        Class c5 = Comparable.class; // 接口
        Class c6 = int[].class; // 一维数组
        Class c7 = int[][].class; // 二维数组
        Class c8 = ElementType.class; // 枚举
        Class c9 = Class.class; // class 类
        Class c10 = void.class; // void

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);
        System.out.println(c10);

        int[] a = new int[10];
        int[] b = new int[100];
        System.out.println(a.getClass().hashCode());
        System.out.println(b.getClass().hashCode());
    }
}
