package _15_.other;

/**
 * @author zhangyn
 * @description
 * @date 2020-01-06 23:36
 */
/** 此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型*/
public class Generic<T> {
    /** 在类中声明的泛型，在整个类里都可以使用，除了静态的部分，因为泛型必须是实例化的时候声明*、
    /** 静态区域的代码在编译期就已经确定，只与类相关*/
    class A <E> {
        T t;
    }
    /** 类里面的方法或类中再次声明的同名泛型是允许的，并且该泛型会覆盖掉外部类的同名泛型*/
    class B <T> {
        T t;
    }
    /** 静态内部类也可以使用泛型，实例化时赋予泛型实际类型*/
    static class C <T> {
        T t;
    }
    /** key这个成员变量的类型为T，key的类型由外部传入*/
    private T key;

    public void setKey(T key){
        this.key = key;
    }
    public T getKey(){
        return this.key;
    }

    public static void main(String[] args) {
        // 实例化类的时候，指定泛型的具体类型
        Generic<String> g = new Generic<>();
        g.setKey("hello");
        String key = g.getKey();
        System.out.println(key);
        // 编译报错，不能使用泛型T，因为T属于实例，不属于类，不能在static方法里用类的泛型
        //        T t = null;
    }

    /**这里的静态方法里的T，和类上声明的T没有关系*/
    public static <T> T getKey(T t){
        return t;
    }
}
