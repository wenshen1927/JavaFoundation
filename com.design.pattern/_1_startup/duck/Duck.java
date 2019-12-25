package _1_startup.duck;

/**
 * 鸭子类
 */
public abstract class Duck {
    protected FlyBehavior flyBehavior ;
    protected QuackBehavior quackBehavior;
    void swim(){
        System.out.println("Swim!");
    }
    public abstract void  display();
    public  void performFly(){
        flyBehavior.fly();
    }

    public  void performQuack(){
        quackBehavior.quack();
    }

    public void setFlyBehavior(Class<?> type) throws Exception {
        this.flyBehavior = (FlyBehavior) type.getDeclaredConstructor().newInstance();
    }

    public void setQuackBehavior(Class<?> type) throws Exception{
        this.quackBehavior = (QuackBehavior) type.getDeclaredConstructor().newInstance();
    }
}
