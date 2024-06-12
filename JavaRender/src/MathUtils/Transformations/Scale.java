package MathUtils.Transformations;

import Vectors.Shapes.Primitives.Vector;

public class Scale implements LinearTransform {
    private double x;
    private double y;
    private double z;

    public Scale(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void transform(Vector v) {
        v.x *= x;
        v.y *= y;
        v.z *= z;
    }
}
