package _8_._8_2_shape;

import java.util.Random;

/**
 * @author zhangyn
 * @description
 * @date 2019-11-10 11:19
 */
public class Shapes {
    public static void main(String[] args) {
        RandomShapeGenerator generator = new RandomShapeGenerator();
        Shape[] shapes = new Shape[9];
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = generator.next();
        }
        for (Shape s :
                shapes) {
            s.draw();
            s.print();
            System.out.println("============");
        }
    }
}

class RandomShapeGenerator {
    private Random random = new Random(101);

    public Shape next() {
        switch (random.nextInt(3)) {
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
            default:
        }
        return null;
    }
}

/**
 * 基类
 */
class Shape {
    public void draw() {

    }

    public void erase() {

    }

    public void print() {
        System.out.println("shape.print()");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Circle.erase");
    }

    @Override
    public void print() {
        System.out.println("Circle.print()");
    }
}

class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Square.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Square.erase");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Triangle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Triangle.erase");
    }
}


