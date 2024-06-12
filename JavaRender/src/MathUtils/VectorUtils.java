package MathUtils;

import Vectors.Shapes.Primitives.Vector;

public class VectorUtils {
    public static double distance(Vector v1, Vector v2) {
        return Math.sqrt(Math.pow(v1.x - v2.x, 2) + Math.pow(v1.y - v2.y, 2) + Math.pow(v1.z - v2.z, 2));
    }
}
