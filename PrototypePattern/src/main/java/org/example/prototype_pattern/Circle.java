package org.example.prototype_pattern;

public class Circle extends Shape {


    public Circle(){ this.type = "CIRCLE"; }

    @Override
    public void draw() {
        System.out.println("Draw a circle: " + super.toString());
    }
}
