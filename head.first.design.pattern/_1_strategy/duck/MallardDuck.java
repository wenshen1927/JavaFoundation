package _1_strategy.duck;

public class MallardDuck extends Duck {
    public MallardDuck() {
        // 子类继承的父类成员变量，可以不声明;前提是父类声明的成员变量不能是private
        super.flyBehavior = new FlyWithWings();
        super.quackBehavior = new Squeak();
    }
    @Override
    public void display() {
        System.out.println("I am a real Mallard Duck");
    }
}
