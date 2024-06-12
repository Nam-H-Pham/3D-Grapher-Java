package MathUtils.Transformations;

import Vectors.Shapes.Primitives.Vector;

public class Rotation implements LinearTransform {
    double[][] rotationMatrix = new double[3][3];

    public Rotation(double angle, Vector axis) {
        double x = axis.x;
        double y = axis.y;
        double z = axis.z;

        double cos = Math.cos(angle);
        double sin = Math.sin(angle);

        rotationMatrix[0][0] = cos + x * x * (1 - cos);
        rotationMatrix[0][1] = x * y * (1 - cos) - z * sin;
        rotationMatrix[0][2] = x * z * (1 - cos) + y * sin;

        rotationMatrix[1][0] = y * x * (1 - cos) + z * sin;
        rotationMatrix[1][1] = cos + y * y * (1 - cos);
        rotationMatrix[1][2] = y * z * (1 - cos) - x * sin;

        rotationMatrix[2][0] = z * x * (1 - cos) - y * sin;
        rotationMatrix[2][1] = z * y * (1 - cos) + x * sin;
        rotationMatrix[2][2] = cos + z * z * (1 - cos);
    }

    @Override
    public void transform(Vector v) {
        double x = v.x;
        double y = v.y;
        double z = v.z;

        v.x = rotationMatrix[0][0] * x + rotationMatrix[0][1] * y + rotationMatrix[0][2] * z;
        v.y = rotationMatrix[1][0] * x + rotationMatrix[1][1] * y + rotationMatrix[1][2] * z;
        v.z = rotationMatrix[2][0] * x + rotationMatrix[2][1] * y + rotationMatrix[2][2] * z;
    }



}
