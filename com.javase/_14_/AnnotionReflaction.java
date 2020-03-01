package _14_;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotionReflaction {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        p.age = 22;
        test(p);
    }

    public static void test(Object object) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class c = object.getClass();

        Field age = c.getDeclaredField("age");
        System.out.println(age.getInt(object));

        Method sayHello = c.getDeclaredMethod("sayHello");
        sayHello.setAccessible(true);
        sayHello.invoke(object);

        System.out.println(c.isAnnotationPresent(MyAnno.class));

        System.out.println(age.getDeclaredAnnotation(MyAnno.class).name());

    }
}

@MyAnno(name = "BB")
class Person {
    @MyAnno(name = "Cc")
    int age;

    @MyAnno
    public Person() {
    }

    @MyAnno
    private void sayHello() {
        System.out.println("Hello");
    }
}
