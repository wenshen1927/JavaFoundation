package _11_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * List里允许添加null值的思考
 */

public class AddNullToList {

    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();

        strs.add("A");
        strs.add(null);
        strs.add("B");
        strs.add(null);
        strs.set(0,null);

        System.out.println(strs);

        String[] strArr = new String[]{"A",null,"B",null};
        System.out.println(Arrays.toString(strArr));
    }

}
