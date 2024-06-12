package Vectors.Shapes.Primitives;

import Camera.Camera;
import MathUtils.Transformations.LinearTransform;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ShapeObject {
    Vector origin;
    ArrayList<Triangle> triangles;

    public ShapeObject(Vector origin) {
        this.origin = origin;
        triangles = new ArrayList<Triangle>();
    }

    public void addTriangle(Triangle t) {
        triangles.add(t);
    }

    public void transform(LinearTransform t) {
        Set<Vector> shapeVectors = new HashSet<>();
        for (Triangle triangle : triangles) {
            shapeVectors.addAll(triangle.getArrayList());
        }

        for (Vector v : shapeVectors) {
            v.transform(t);
        }

        origin.transform(t);
    }

    public void draw(Camera camera) {
        // sort triangles by distance to camera
        triangles.sort((t1, t2) -> {
            Vector t1Midpoint = new Vector((t1.a.x + t1.b.x + t1.c.x) / 3, (t1.a.y + t1.b.y + t1.c.y) / 3, (t1.a.z + t1.b.z + t1.c.z) / 3);
            Vector t2Midpoint = new Vector((t2.a.x + t2.b.x + t2.c.x) / 3, (t2.a.y + t2.b.y + t2.c.y) / 3, (t2.a.z + t2.b.z + t2.c.z) / 3);
            double d1 = camera.getDistanceFromCamera(t1Midpoint);
            double d2 = camera.getDistanceFromCamera(t2Midpoint);
            return (int) (d2 - d1);
        });

        for (Triangle t : triangles) {
            t.draw(camera);
        }
    }
}
