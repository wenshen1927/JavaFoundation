package _1_strategy.duck;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Can not fly!");
    }
}
