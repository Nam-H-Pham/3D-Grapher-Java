package Camera;

import Vectors.Shapes.Primitives.Vector;

import javax.swing.*;
import java.awt.*;

public class OrthographicCamera extends Camera{

    Double greatestZ = null;
    Double smallestZ = null;

    public OrthographicCamera(JFrame frame) {
        super(frame);
    }

    @Override
    public void drawLine(Vector a, Vector b) {
        int halfWidth = frame.getWidth() / 2;
        int halfHeight = frame.getHeight() / 2;

        g.setColor(Color.BLACK);

        g.drawLine((int) (a.x + halfWidth), (int) (a.y + halfHeight), (int) (b.x + halfWidth), (int) (b.y + halfHeight));

    }

    @Override
    public void drawPoint(Vector a) {
        int halfWidth = frame.getWidth() / 2;
        int halfHeight = frame.getHeight() / 2;

        g.setColor(Color.BLACK);

        int radius = 1;
        g.fillOval((int) (a.x + halfWidth) - radius, (int) (a.y + halfHeight) - radius, radius * 2, radius * 2);
    }

    @Override
    public void drawTriangle(Vector a, Vector b, Vector c , Boolean fill) {
        super.drawTriangle(a, b, c, fill);

        if (fill) {
            int halfWidth = frame.getWidth() / 2;
            int halfHeight = frame.getHeight() / 2;

            int[] xPoints = {(int) (a.x + halfWidth), (int) (b.x + halfWidth), (int) (c.x + halfWidth)};
            int[] yPoints = {(int) (a.y + halfHeight), (int) (b.y + halfHeight), (int) (c.y + halfHeight)};

            //scale color based on distance
            Vector middle = new Vector((a.x + b.x + c.x) / 3, (a.y + b.y + c.y) / 3, (a.z + b.z + c.z) / 3);
            double distance = getDistanceFromCamera(middle);

            greatestZ = greatestZ == null ? distance : Math.max(greatestZ, distance);
            smallestZ = smallestZ == null ? distance : Math.min(smallestZ, distance);

            int color = (int) (255 - (255 * (distance - smallestZ) / (greatestZ - smallestZ)));

            g.setColor(new Color(color, color, color));

            g.fillPolygon(xPoints, yPoints, 3);
        }
    }

    @Override
    public double getDistanceFromCamera(Vector a) {
        return a.z;
    }

}
