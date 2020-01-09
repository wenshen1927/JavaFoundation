package _15_._15_8_erase_compensation._15_8_1_;

/**
 * @author zhangyn
 * @description
 * 泛型擦除，那么如何在运行期拿到泛型的类型信息呢？
 * 1、调用泛型方法或者实现泛型类的时候，就要传入泛型的类型信息，
 * 2、可以用一个工厂类生成泛型对象,或者用模板方法创建运行期对象
 * @date 2020-01-08 21:28
 */
public class ClassAsFactory<T> {
    T x;
    public ClassAsFactory(Class<T> kind){
        try {
            x = kind.newInstance();
        } catch (InstantiationException e) {

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
class Employee {}

class InstantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Employee> cf = new ClassAsFactory<>(Employee.class);
        System.out.println("ClassAsFactory<Employee> succeed");

        ClassAsFactory<Integer> cf1= new ClassAsFactory<>(Integer.class);

    }

}
