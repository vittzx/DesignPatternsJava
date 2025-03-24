package org.example.prototype_pattern;

public class Square extends Shape{

    public Square(){ this.type = "SQUARE";}

    @Override
    public void draw() {
        System.out.println("Draw a square: " + super.toString());
    }
}
