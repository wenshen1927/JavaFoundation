package _1_strategy.duck;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("quack ! ");
    }
}
