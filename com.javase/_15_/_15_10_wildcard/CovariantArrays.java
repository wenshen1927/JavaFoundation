package _15_._15_10_wildcard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyn
 * @description 数组对持有的对象类型在编译期没有检查的机制，只有在运行期才能检查出来数组持有对象的类型
 * 容器类加上泛型则可以在编译期检查类型，所以尽量使用容器类
 * @date 2020-01-08 21:56
 */
public class CovariantArrays {
    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new Jonathan();
        // 跑出异常ArrayStoreException，因为运行时会检查fruits的实际类型是Apple
        fruits[0] = new Fruit();
        // 跑出异常ArrayStoreException
        fruits[0] = new Orange();
        //
        List<? extends Fruit> flist = new ArrayList<Apple>();
        // 全部编译错误，不能向flist里添加任何对象
//        flist.add(new Apple());
//        flist.add(new Orange());
//        flist.add(new Object());
        flist.add(null);
        // 但是我们知道get出来的对象至少是一个Fruit对象
        Fruit fruit = flist.get(0);

        List<? extends Fruit> flist1 = new ArrayList<Apple>();
    }
}

class Fruit {
}

class Apple extends Fruit {
}

class Jonathan extends Apple {
}

class Orange extends Fruit {
}

