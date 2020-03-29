package _1_strategy.duck;

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

        System.out.println("after another Duck behavior");
        mallard.performFly();
        mallard.display();
    }
}
