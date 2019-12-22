package _14_;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 反射用来检查类的机构，包括:类的属性、方法、构造器等
 *
 * @author zhangyn
 * @date 2018/11/16 下午2:22
 */
public class ReflectionTest {
    public static void main(String[] args) {
        Double d = new Double(20.0);
        printFields(d.getClass());
    }

    /**
     * 打印类中所有的属性
     *
     * @param c
     */
    public static void printFields(Class c) {
        Field[] declaredFields = c.getDeclaredFields();
        for (Field f :
                declaredFields) {
            Class type = f.getType();//获取属性的类型
            String name = f.getName();//获取属性的名称
            System.out.println();
            //modifiers可以得到属性的权限如private,public static final等
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0) {
                System.out.println(modifiers + " ");
            }
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}
