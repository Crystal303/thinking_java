/*package chap14.exercise;

import java.util.*;

abstract class Shape {
    void draw() { System.out.println(this + ".draw()"); }
    @Override
    abstract public String toString();
}

class Circle extends Shape {
    @Override
    public String toString() { return "Circle"; }
}

class Square extends Shape {
    @Override
    public String toString() { return "Square"; }
}

class Triangle extends Shape {
    @Override
    public String toString() { return "Triangle"; }
}

class Rhomboid extends Shape {
    @Override
    public String toString() { return "Rhomboid"; }
}

public class Shapes4 {
    public static void main(String[] args) {
        // upCasting to Shape
        List<Shape> shapeList = Arrays.asList(new Circle(), new Triangle(), new Rhomboid());
        for (Shape shape :
                shapeList) {
            System.out.println(shape);
        }

        Rhomboid r = new Rhomboid();
        Shape s    = (Shape)r;
        s.draw();
        // check type for downcast;
        if (s instanceof Circle) {
            ((Circle)s).draw();
        } else if (!(s instanceof Circle)) {
            System.out.println("(Shape)r is not a Circle!");
        }

    }
}*/
