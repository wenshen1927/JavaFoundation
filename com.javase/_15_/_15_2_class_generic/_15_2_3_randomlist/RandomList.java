package _15_._15_2_class_generic._15_2_3_randomlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author zhangyn
 * @description 随机访问List中的元素
 * @date 2019-12-13 23:51
 */
public class RandomList<T> {
    List<T> storage = new ArrayList<>();
    Random rand = new Random(1);

    public void add(T element) {
        storage.add(element);
    }

    public T select() {
        return storage.get(rand.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<>();
        for (String s :
                "the quick brown fox jumped over the lazy brown dog".split(" ")) {
            rs.add(s);
        }
        for (int i = 0; i < 11; i++) {
            System.out.println(rs.select());
        }
    }
}
