import Camera.Camera;
import Camera.OrthographicCamera;
import MathUtils.Transformations.LinearTransform;
import MathUtils.Transformations.Move;
import MathUtils.Transformations.Rotation;
import MathUtils.Transformations.Scale;
import Vectors.Shapes.Cube;
import Vectors.Shapes.LoadedAsset;
import Vectors.Shapes.Primitives.ShapeObject;
import Vectors.Shapes.Primitives.Vector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovingCube extends JPanel implements ActionListener {

    //private ShapeObject cube = new Cube(new Vector(0, 0, 0), 50);
    private ShapeObject cube = new LoadedAsset(new Vector(0,0,0), "src/Assets/plant.obj");

    private final double moveSpeed = 0.5;
    private Timer timer;

    private final JFrame frame = new JFrame("Moving Cube");
    private final Camera camera = new OrthographicCamera(frame);

    public MovingCube() {
        timer = new Timer(10, this);
        timer.start();

        frame.add(this);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        camera.setGraphics(g);
        cube.draw(camera);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        LinearTransform t2 = new Rotation(0.01, new Vector(1, 1, 0));
        cube.transform(t2);

        LinearTransform t = new Scale(1.01, 1.01, 1.01);
        cube.transform(t);

        repaint();
    }

    public static void main(String[] args) {
        MovingCube movingSquare = new MovingCube();
    }
}
