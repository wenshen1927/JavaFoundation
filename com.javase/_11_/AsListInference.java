package _11_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

class Snow{}
class Power extends Snow{}
class Light extends Power{}
class Heavy extends Power{}
class Crusty extends Snow{}
class Slush extends Snow{}

public class AsListInference {
    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(new Crusty(), new Slush(), new Power());
//        snow1.add(new Heavy());// UnsupportedOperationException
        List<Snow> snow2 = new ArrayList<Snow>(Arrays.asList( new Light(), new Heavy()));
        for (Snow snow : snow2) {
            System.out.println(snow);
            snow2.remove(snow);
            System.out.println(snow2);
        }
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        ListIterator<Integer> it = integers.listIterator();

        while (it.hasNext()) {
            System.out.println(it.next()+","+it.nextIndex()+","+it.previousIndex());
        }
        while (it.hasPrevious()) {
            System.out.println(it.previousIndex()+","+it.previous());
        }


    }
}
