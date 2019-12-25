package _15_._15_7_type_erasure;

import java.util.*;

/**
 * @Classname LostInfomation
 * @Description .getClass().getTypeParameters() ： 返回一个TypeVariable对象数组，表示有泛型声明所声明的类型参数
 * @Date 2019/12/25 22:32
 * @Created by Super Man
 */
public class LostInformation {
    public static void main(String[] args) {
        List<Frob> list = new ArrayList<>();
        Map<Frob, Fnorkle> map = new HashMap<>();
        Quark<Fnorkle> quark = new Quark<>();
        Particle<Long, Double> particle = new Particle<>();

        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(particle.getClass().getTypeParameters()));


    }
}

class Frob {
}

class Fnorkle {
}

class Quark<Q> {
}

class Particle<POSITION, MOMENTUM> {
}
