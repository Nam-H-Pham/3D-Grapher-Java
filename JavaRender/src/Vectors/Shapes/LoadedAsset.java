package Vectors.Shapes;

import Vectors.Shapes.Primitives.ShapeObject;
import Vectors.Shapes.Primitives.Triangle;
import Vectors.Shapes.Primitives.Vector;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LoadedAsset extends ShapeObject {

    ArrayList<Vector> vertices = new ArrayList<Vector>();

    public LoadedAsset(Vector origin, String path) {
        super(origin);
        try {
            Scanner scanner = new Scanner(new File(path));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.startsWith("v ")) {
                    String[] values = line.split(" ");
                    double x = Double.parseDouble(values[1]);
                    double y = Double.parseDouble(values[2]);
                    double z = Double.parseDouble(values[3]);
                    Vector v = new Vector(x, y, z);
                    vertices.add(v);
                } else if (line.startsWith("f ")) {
                    String[] values = line.split(" ");


                    //if length is 4, it's a triangle
                    if (values.length == 4) {
                        int[] indices = new int[3];
                        for (int i = 1; i < 4; i++) {
                            indices[i - 1] = Integer.parseInt(values[i].split("/")[0]) - 1;
                        }
                        Vector a = vertices.get(indices[0]);
                        Vector b = vertices.get(indices[1]);
                        Vector c = vertices.get(indices[2]);
                        addTriangle(new Triangle(a, b, c));

                        //if length is 5, it's a quad
                    } else if (values.length == 5) {
                        int[] indices = new int[4];
                        for (int i = 1; i < 5; i++) {
                            indices[i - 1] = Integer.parseInt(values[i].split("/")[0]) - 1;
                        }
                        Vector a = vertices.get(indices[0]);
                        Vector b = vertices.get(indices[1]);
                        Vector c = vertices.get(indices[2]);
                        Vector d = vertices.get(indices[3]);
                        addTriangle(new Triangle(a, b, c));
                        addTriangle(new Triangle(a, c, d));
                    }


                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LoadedAsset asset = new LoadedAsset(new Vector(0,0,0), "src/Assets/plant.obj");
    }

}