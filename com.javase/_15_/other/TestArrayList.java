package _15_.other;

import java.util.ArrayList;

/**
 * @author zhangyn
 * @description
 * @date 2020-01-06 22:48
 */
public class TestArrayList {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Hello");
        String o = (String)list.get(0);
        list.add(new Integer(122));
        // 编译期不会报错，运行期会报错：ClassCastException
        String o1 =(String) list.get(1);
    }
}
class StringArrayList {
    String[] array;
    public void add(String e){}
    public void remove(int index){}
//    public String get(int index){}
}
//public class ArrayList<T> implements List<T> {
//    private T[] array;
//    public void add(T e){}
//    public void remove(int index){}
//    public T get(int index){}
//}

