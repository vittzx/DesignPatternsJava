package org.example.prototype_pattern;

import java.util.Hashtable;

public class ShapeCache {
    private static final Hashtable<Long, Shape> shapeMap = new Hashtable<>();

    public static Shape getShape(Long id){
        Shape cachedShape = shapeMap.get(id);
        return (Shape) cachedShape.clone();
    }

    public static void loadCache(){
        Circle circle = new Circle();
        circle.setId(Long.valueOf("1"));
        shapeMap.put(circle.getId(), circle);

        Square square = new Square(); // init Square/Circle thats returns a Shape object...
        square.setId(Long.valueOf("2"));
        shapeMap.put(square.getId(), square); // method putShapeOnMap(Long id, Shape shape){...}
    }

}
