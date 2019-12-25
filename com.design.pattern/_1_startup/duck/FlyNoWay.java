package _1_startup.duck;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Can not fly!");
    }
}
