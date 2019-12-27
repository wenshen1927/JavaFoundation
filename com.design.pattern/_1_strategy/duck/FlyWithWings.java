package _1_strategy.duck;

public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("fly with wings !");
    }
}
