package _1_strategy.duck;

public class ModelDuck extends Duck {

    public ModelDuck() {
        // 一开始，我们的模型鸭子是不会飞的
        // 在运行期我们动态地设置它的飞行行为，他就可以飞了
        super.flyBehavior = new FlyNoWay();
        super.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I am a model duck!");
    }
}
