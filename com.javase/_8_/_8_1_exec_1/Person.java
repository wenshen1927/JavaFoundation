package _8_._8_1_exec_1;

/**
 * @author zhangyn
 * @description 基类
 * @date 2019-11-10 10:47
 */
public class Person {
    public void ride(Cycle cycle) {
        System.out.println(cycle.toString());
        cycle.wheels();
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.ride(new Unicycle());
        p.ride(new Bicycle());
        p.ride(new Tricycle());

    }
}

class Cycle {
    @Override
    public String toString() {
        return "cycle";
    }

    public int wheels() {
        return 0;
    }
}

class Unicycle extends Cycle {
    @Override
    public String toString() {
        return "Unicycle";
    }
}

class Bicycle extends Cycle {
    @Override
    public String toString() {
        return "Bicycle";
    }
}

class Tricycle extends Cycle {
    @Override
    public String toString() {
        return "Tricycle";
    }
}

