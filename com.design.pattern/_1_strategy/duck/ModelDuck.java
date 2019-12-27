package _1_strategy.duck;

public class ModelDuck extends Duck {

    public ModelDuck(){
        super.flyBehavior = new FlyNoWay();
        super.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I am a model duck!");
    }
}
