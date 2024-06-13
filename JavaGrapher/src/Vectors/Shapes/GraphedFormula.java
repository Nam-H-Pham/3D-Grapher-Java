package Vectors.Shapes;

import Vectors.Shapes.Primitives.ShapeObject;
import Vectors.Shapes.Primitives.Triangle;
import Vectors.Shapes.Primitives.Vector;

import java.util.function.BiFunction;

public class GraphedFormula extends ShapeObject {
    public GraphedFormula(Vector origin, int size, double step, BiFunction<Double, Double, Double> f) {
        super(origin);
        double x = origin.x;
        double y = origin.y;
        double z = origin.z;
        // y = f(x, z)
        for (double i = x - size; i < x + size; i += step) {
            for (double j = z - size; j < z + size; j += step) {
                Vector a = new Vector(i, y + f.apply(i, j), j);
                Vector b = new Vector(i + step, y + f.apply(i + step, j), j);
                Vector c = new Vector(i + step, y + f.apply(i + step, j + step), j + step);
                Vector d = new Vector(i, y + f.apply(i, j + step), j + step);
                addTriangle(new Triangle(a, b, c));
                addTriangle(new Triangle(a, c, d));
            }
        }
    }
}
