package Vectors.Shapes;

import Vectors.Shapes.Primitives.ShapeObject;
import Vectors.Shapes.Primitives.Triangle;
import Vectors.Shapes.Primitives.Vector;

public class Cube extends ShapeObject {

    public Cube(Vector origin, int size) {
        super(origin);
        double x = origin.x;
        double y = origin.y;
        double z = origin.z;
        Vector a = new Vector(x, y, z);
        Vector b = new Vector(x + size, y, z);
        Vector c = new Vector(x + size, y + size, z);
        Vector d = new Vector(x, y + size, z);
        Vector e = new Vector(x, y, z + size);
        Vector f = new Vector(x + size, y, z + size);
        Vector g = new Vector(x + size, y + size, z + size);
        Vector h = new Vector(x, y + size, z + size);

        addTriangle(new Triangle(a, b, c));
        addTriangle(new Triangle(a, c, d));
        addTriangle(new Triangle(a, e, f));
        addTriangle(new Triangle(a, f, b));
        addTriangle(new Triangle(b, f, g));
        addTriangle(new Triangle(b, g, c));
        addTriangle(new Triangle(c, g, h));
        addTriangle(new Triangle(c, h, d));
        addTriangle(new Triangle(d, h, e));
        addTriangle(new Triangle(d, e, a));
        addTriangle(new Triangle(e, h, g));
        addTriangle(new Triangle(e, g, f));
    }
}
