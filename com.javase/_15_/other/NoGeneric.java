package _15_.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname NoGeneric
 * @Description 如果没有泛型，会怎么样
 * @Date 2019/12/29 18:55
 * @Created by Super Man
 */
public class NoGeneric {
    public static void main(String[] args) {
        // 在一个容器里，我们可以放不同类型的数据，但是如果我们想规定这个容器只能存某一种类型的对象，却没有办法
        List list1 =new ArrayList();
        list1.add(1);
        list1.add("a");
        list1.add(1.2);
        System.out.println(list1);
        // 如上面的list1，可以存入多种数据类型。但是我们在取出的时候，想要知道集合元素的确切类型，却很麻烦。
        for (int i = 0; i < list1.size(); i++) {
            Object obj = list1.get(i);
            if (obj instanceof Integer){
                System.out.println(obj + " : Integer");
            }else if (obj instanceof String){
                System.out.println(obj + " : String");
            }else if (obj instanceof Double){
                System.out.println(obj + " : Double");
            }
        }
        // 泛型就是在编译期加入对类型参数的检查
        List<String> list2 = new ArrayList<>();
//        list2.add(1); // 编译错误
        list2.add("String");
    }
}
