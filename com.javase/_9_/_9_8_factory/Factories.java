package _9_._9_8_factory;

/**
 * @author zhangyn
 * @description
 * 工厂的作用：通过方法，产生实例对象；而不是通过构造器产生对象
 * @date 2019-12-08 23:28
 */
public class Factories {
    public static void serviceConsume(ServiceFactory factory){
        Service service = factory.getService();
        service.method1();
        service.method2();
    }

    public static void main(String[] args) {
        Implement1Factory factory1 = new Implement1Factory();
        serviceConsume(factory1);

        Implement2Factory factory2 = new Implement2Factory();
        serviceConsume(factory2);
    }
}

interface Service {
    void method1();
    void method2();
}

interface ServiceFactory{
    Service getService();
}

class Implement1 implements Service {

    @Override
    public void method1() {
        System.out.println("Implement1 method1");
    }

    @Override
    public void method2() {
        System.out.println("Implement1 method2");
    }
}

class Implement2 implements Service {

    @Override
    public void method1() {
        System.out.println("Implement2 method1");
    }

    @Override
    public void method2() {
        System.out.println("Implement2 method2");
    }
}

class Implement1Factory implements ServiceFactory {
    @Override
    public Service getService() {
        return new Implement1();
    }
}
class Implement2Factory implements ServiceFactory {
    @Override
    public Service getService() {
        return new Implement2();
    }
}
