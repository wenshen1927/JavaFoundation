package _15_._15_2_class_generic;


/**
 * @author zhangyn
 * @description 泛型的基本用法:向容器中存入类型（或其子类）
 * @date 2019-12-13 00:04
 */
public class Holder3<T> {
    private T a;

    public Holder3(T a) {
        this.a = a;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder3<Automobil> h3 = new Holder3<>(new Automobil());
        Automobil a = h3.getA();
        /** 存入指定类型的子类也可以，多态与泛型不冲突*/
        Holder3<Automobil> h4 = new Holder3<>(new Nokia());
//        h3.setA(new String());
//        h3.setA(14);
    }
}
class Automobil {}

class Nokia extends Automobil{}
