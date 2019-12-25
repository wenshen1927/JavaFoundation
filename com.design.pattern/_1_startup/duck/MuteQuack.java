package _1_startup.duck;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Mute !");
    }
}
