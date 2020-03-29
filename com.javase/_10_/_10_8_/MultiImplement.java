package _10_._10_8_;

public class MultiImplement {
    static void takesD(D d){}
    static void takesE(E e){
    }

    public static void main(String[] args) {
        Z z = new Z();
        takesD(z);
        takesE(z.makeE());
    }
}
class D{}
abstract class E{}
class Z extends D {
    void f(){
        System.out.println("outer class f()");
    }
    E makeE(){
        return new E() {};
    }
}

