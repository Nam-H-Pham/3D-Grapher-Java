import Camera.Camera;
import Camera.OrthographicCamera;
import MathUtils.Transformations.LinearTransform;
import MathUtils.Transformations.Move;
import MathUtils.Transformations.Rotation;
import MathUtils.Transformations.Scale;
import Vectors.Shapes.GraphedFormula;
import Vectors.Shapes.Primitives.ShapeObject;
import Vectors.Shapes.Primitives.Vector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graph extends JPanel implements ActionListener {

    //private ShapeObject cube = new Cube(new Vector(0, 0, 0), 50);
    private ShapeObject cube = new GraphedFormula(new Vector(0, 30, 0), 50, 4, (x, z) -> Math.sin(x/20) * Math.cos(z/20) * 20);

    private final double moveSpeed = 1;
    private Timer timer;

    private final JFrame frame = new JFrame("Graphing Calculator");
    private final Camera camera = new OrthographicCamera(frame);

    public Graph() {
        timer = new Timer(10, this);
        timer.start();

        frame.add(this);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //move the cube
        LinearTransform t0 = new Move(0, 0, 10);
        cube.transform(t0);

        //slightly rotate the cube
        LinearTransform t1 = new Rotation(0.12, new Vector(1, 0, 0));
        cube.transform(t1);

        //scale the cube
        int scale = 4;
        LinearTransform t2 = new Scale(scale, scale, scale);
        cube.transform(t2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        camera.setGraphics(g);
        cube.draw(camera);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LinearTransform t2 = new Rotation(0.01, new Vector(0, 1, 0));
        cube.transform(t2);

        repaint();
    }

    public static void main(String[] args) {
        Graph movingSquare = new Graph();
    }
}
