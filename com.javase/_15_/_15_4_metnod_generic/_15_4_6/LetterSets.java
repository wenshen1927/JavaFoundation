package _15_._15_4_metnod_generic._15_4_6;

import java.util.EnumSet;
import java.util.Set;

/**
 * @author zhangyn
 * @description
 * @date 2019-12-21 22:03
 */
public class LetterSets {
    public static void main(String[] args) {
        final Set<CapitalLetter> a = EnumSet.range(CapitalLetter.C, CapitalLetter.F);
        final Set<CapitalLetter> b = EnumSet.range(CapitalLetter.A, CapitalLetter.E);
        System.out.println("a:"+a.toString());
        System.out.println("b:"+b.toString());
        System.out.println(Sets.union(a,b));
        System.out.println(Sets.intersection(a,b));
        System.out.println(Sets.difference(a,b));
        System.out.println(Sets.complement(a,b));
    }

}
