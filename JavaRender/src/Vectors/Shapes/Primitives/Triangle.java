package Vectors.Shapes.Primitives;

import Camera.Camera;
import MathUtils.Transformations.LinearTransform;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Triangle {
    Vector a;
    Vector b;
    Vector c;
    Color color = Color.BLACK;

    public Triangle(Vector a, Vector b, Vector c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void draw(Camera camera) {
        camera.drawTriangle(a, b, c, true);

        a.draw(camera);
        b.draw(camera);
        c.draw(camera);
    }

    public ArrayList<Vector> getArrayList() {
        ArrayList<Vector> vectors = new ArrayList<Vector>();
        vectors.add(a);
        vectors.add(b);
        vectors.add(c);
        return vectors;
    }
}
