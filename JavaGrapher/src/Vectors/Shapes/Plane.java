package Vectors.Shapes;

import Vectors.Shapes.Primitives.ShapeObject;
import Vectors.Shapes.Primitives.Triangle;
import Vectors.Shapes.Primitives.Vector;

public class Plane extends ShapeObject {
    public Plane(Vector origin, int size) {
        super(origin);
        double x = origin.x;
        double y = origin.y;
        double z = origin.z;
        // set horizontal plane
        Vector a = new Vector(x, y, z);
        Vector b = new Vector(x + size, y, z);
        Vector c = new Vector(x + size, y, z + size);
        Vector d = new Vector(x, y, z + size);

        addTriangle(new Triangle(a, b, c));
        addTriangle(new Triangle(a, c, d));

    }

}
