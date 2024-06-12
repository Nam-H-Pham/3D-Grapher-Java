package Vectors.Shapes.Primitives;

import Camera.Camera;
import MathUtils.Transformations.LinearTransform;
import MathUtils.Transformations.Move;

import javax.swing.*;
import java.awt.*;

// This class is a simple 3D vector class
public class Vector {
    public Color color = Color.RED;
    public double x;
    public double y;
    public double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void add(Vector v) {
        x += v.x;
        y += v.y;
        z += v.z;
    }

    public void draw(Camera camera){
        camera.drawPoint(this);
    }

    public void transform(LinearTransform t) {
        t.transform(this);
    }

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public static void main(String[] args) {
        Vector v = new Vector(1, 2, 3);
        System.out.println(v);

        LinearTransform t = new Move(1, 1, 1);
        v.transform(t);
        System.out.println(v);
    }
}
