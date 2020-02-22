package _15_._15_10_wildcard._15_10_1;





import java.applet.Applet;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyn
 * @description
 * @date 2020-01-13 00:52
 */
public class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> list = Arrays.asList(new Fruit());
        Fruit fruit = (Fruit)list.get(0);
        list.contains(new Fruit());
        list.indexOf(new Fruit());
    }
}

class Fruit{}
