package _1_startup.duck;

public class MiniDuckSimulator {
    public static void main(String[] args) throws Exception {
        Duck mallard = new MallardDuck();
        mallard.performFly();
        mallard.performQuack();
        mallard.display();

        System.out.println("==================");
        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(FlyRocketPowered.class);
        model.performFly();
    }
}
