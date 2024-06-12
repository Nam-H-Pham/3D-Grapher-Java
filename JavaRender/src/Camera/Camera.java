package Camera;

import Vectors.Shapes.Primitives.Vector;

import javax.swing.*;
import java.awt.*;

public abstract class Camera {

    protected Graphics g;
    protected JFrame frame;

    public Camera(JFrame frame) {
        this.frame = frame;
    }

    public void setGraphics(Graphics g) {
        this.g = g;
    }

    public Graphics getGraphics() {
        return g;
    }

    public void drawLine(Vector a, Vector b) {
        return;
    }

    public void drawPoint(Vector a) {
        return;
    }

    public void drawTriangle(Vector a, Vector b, Vector c, Boolean fill) {
        drawLine(a, b);
        drawLine(b, c);
        drawLine(c, a);
    }

    public double getDistanceFromCamera(Vector a) {
        return 0;
    }

}
