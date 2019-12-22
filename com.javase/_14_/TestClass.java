package _14_;

import java.util.ArrayList;

/**
 * Class类与反射的理解
 *
 * @author zhangyn
 * @date 2018/11/16 下午1:46
 */
public class TestClass {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        ArrayList<Integer> list = new ArrayList<>();
        //如何获取类信息？三种方法：
        //方法一：对象.getClass()方法
        Class<? extends ArrayList> aClass = list.getClass();
        //方法二：Class的静态方法Class.forName(类名);
        Class c1 = null;
        try {
            c1 = Class.forName(aClass.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(aClass.getName());
        System.out.println(c1);
        //方法三：调用类的class属性
        System.out.println(ArrayList.class);

        //反射的方式创建新的实例
        Object o = Class.forName("java.util.ArrayList").newInstance();

    }
}
