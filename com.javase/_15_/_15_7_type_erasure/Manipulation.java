package _15_._15_7_type_erasure;

/**
 * @Classname Manipulation
 * @Description 泛型类的边界
 * @Date 2019/12/25 22:58
 * @Created by Super Man
 */
public class Manipulation {
    public static void main(String[] args) {
        HasF hf =new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hf);
        manipulator.manipulate();
    }
}
class  Manipulator<T> {
    private T obj;
    public Manipulator(T obj){
        this.obj = obj;
    }
    public void manipulate(){
        // 编译报错：编译期，泛型成员变量并不知道他自己可以调用什么方法
//         obj.f();
    }
}

/**
 * 泛型参数T必须是HasF类，或者HasF的导出类，这样成员变量T才可以调用f()方法
 * @param <T>
 */
class Manipulator2<T extends HasF> {
    private T obj;
    public Manipulator2(T obj){
        this.obj = obj;
    }
    public void manipulate(){
        //
         obj.f();
    }
}

/**
 * Manipulator2中的泛型好像没什么用，我们直接手动擦除泛型，也可以实现同样的效果
 */
class Manipulator3{
    private HasF obj;
    public Manipulator3(HasF obj){
        this.obj = obj;
    }
    public void manipulate(){
        obj.f();
    }
}

/**
 * 不能因为Manipulator3 就认为<T extends HasF>无用。比如我们需要返回值是泛型对象的时候，就有用
 * @param <T>
 */
class ReturnGenericType<T extends HasF>{
    private T obj;
    public ReturnGenericType(T obj){
        this.obj = obj;
    }
    public T manipulate(T t){
        return obj;
    }
}


class HasF {
    public void f(){
        System.out.println("Hasf.f()");
    }
}
