package _1_startup.duck;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("squeak!");
    }
}
