package org.example;

import org.example.prototype_pattern.Circle;
import org.example.prototype_pattern.ShapeCache;
import org.example.prototype_pattern.Square;

public class Main {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Circle circleCloned = (Circle) ShapeCache.getShape(Long.valueOf("1"));
        System.out.println("Clone circle: "+ circleCloned.toString());
        circleCloned.draw();

        Square squareCloned = (Square) ShapeCache.getShape(Long.valueOf("2"));
        System.out.println("Square circle: "+ squareCloned.toString());
        squareCloned.draw();
    }
}