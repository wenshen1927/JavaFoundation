package _8_._8_5_up_transform;

/**
 * @author zhangyn
 * @description is - a  ： 导出类和基类有完全相同的一套接口 ，是一种"纯粹"的继承
 * is - like -a ：导出类有一些基类不具备的方法，实现其他的特性
 * @date 2019-12-01 00:33
 */
public class Shape {
    public void draw() {
        System.out.println("Shape draw()");
    }

    public static void main(String[] args) {
        Shape shape = new Circle();
        shape.draw();
//        shape.erase();  // shape引用不能够访问子类的特性方法
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle draw()");
    }

    public void erase() {
        System.out.println("Circel erase()");
    }
}
