package 第四章_类和接口;

public class 类层次优先于标签类 {
}

/**
 * 标签类
 */
class Figure {
    enum Shape {
        RECTANGLE, CIRCLE;
    }

    Shape shape = null;
    double  length;
    double width;
    double radius;

    Figure(Double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    Figure(Double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case CIRCLE:
                return Math.PI *(radius * radius);
            case RECTANGLE:
                return length * width;
            default:
                throw new RuntimeException();
        }
    }
}

/**
 * 类层次
 */
abstract class Figure1 {
    abstract double area();
}

class Circle1 extends Figure1 {
    final  double radius;
    Circle1(Double radius) {
        this.radius = radius;
    }

    double area() {
        return Math.PI * (radius*radius);
    }
}

class Rectangle extends  Figure1 {
    final double length;
    final double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    double area() {
        return length* width;
    }
}