package _1_strategy.duck;

/**
 * 鸭子类
 */
public abstract class Duck {
    // 注意：这里设置成private 就没办法让子类继承了，也就没办法在子类里实例化，会导致调用perform方法的时候空指针
//    private FlyBehavior flyBehavior;
//    private QuackBehavior quackBehavior;
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;
    void swim() {
        System.out.println("Swim!");
    }
    public abstract void display();
    public void performFly() {
        flyBehavior.fly();
    }
    public void performQuack() {
        quackBehavior.quack();
    }
    /**
     * 传入动作的class对象
     *
     * @param type
     * @throws Exception
     */
    public void setFlyBehavior(Class<?> type) throws Exception {
        // 在运行期设置动作
        this.flyBehavior = (FlyBehavior) type.getDeclaredConstructor().newInstance();
    }
    /**
     * 传入一个具体的动作实例
     *
     * @param fb
     * @throws Exception
     */
    public void setFlyBehavior(FlyBehavior fb) {
        this.flyBehavior = fb;
    }
    public void setQuackBehavior(Class<?> type) throws Exception {
        this.quackBehavior = (QuackBehavior) type.getDeclaredConstructor().newInstance();
    }
    public void setQuackBehavior(QuackBehavior qb) {
        this.quackBehavior = qb;
    }
}
