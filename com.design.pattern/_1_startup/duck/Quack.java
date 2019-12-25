package _1_startup.duck;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("quack ! ");
    }
}
