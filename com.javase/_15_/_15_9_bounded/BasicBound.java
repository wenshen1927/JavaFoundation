package _15_._15_9_bounded;

import java.awt.*;

/**
 * @Classname BasicBound
 * @Description TODO
 * @Date 2020/1/1 22:32
 * @Created by Super Man
 */
interface HasColor {
    Color getColor();
}

class Dimension {
    public int x, y, z;
}

class Colored<T extends HasColor> {
    T item;

    Colored(T item) {
        this.item = item;
    }

    // 这里的泛型参数T,由于限定了其边界，所以可以用t的实例来调用方法
    Color color() {
        return this.item.getColor();
    }
}

// 这里编译错误，必须类在前，接口在后
// class ColoredDimention<T extends HasColor&Dimension>{ }

// 多重边界
class ColoredDimention<T extends Dimension & HasColor> {
    /**这里的泛型实例其实就是一个Dimension和HasColor的子类实例对象*/
    T item;

    ColoredDimention(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    Color color() {
        return item.getColor();
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }
}

interface Weight {int weight();}

//泛型对象只能继承一个类和多个接口
class Solid<T extends Dimension&HasColor&Weight>{
    T item;
    Solid(T item){
        this.item = item;
    }
    T getItem(){
        return item;
    }
    Color color(){
        return item.getColor();
    }
    int getX(){
        return item.x;
    }
    int weight(){
        return item.weight();
    }
}
class Bounded extends Dimension implements HasColor,Weight{

    @Override
    public  Color getColor() {
        return null;
    }

    public <V extends HasColor> void getColor(V item){
//        V value = new V();// 泛型对象没有默认构造器，所以不能new出来
        Color color = item.getColor();
    }

    @Override
    public int weight() {
        return 0;
    }
}
class Bounded1 extends Dimension implements HasColor{
    @Override
    public Color getColor() {
        return null;
    }
}
public class BasicBound {
    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<>(new Bounded());
        solid.color();
        solid.getX();
        solid.weight();
        Bounded item = solid.getItem();
        // Bounded1 就不行，因为它并没有完全符合Solid里泛型的继承规则，少实现了一个接口Weight，他们具有不同的继承结构
//        Solid<Bounded1> solid1 = new Solid<Bounded1>();
        // 用通配符就可以
        Solid<? extends Bounded> solid1 = new Solid<>(new Bounded());
    }
}

