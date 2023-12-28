import java.awt.Graphics;
import java.awt.Color;
import java.awt.Polygon;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GraphicTools {

    public void plot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);
    }

    public void plotIfOutsideRange(Graphics g, int value, int minRange, int maxRange, int x, int y, int size){
        if(value > maxRange || value < minRange){
            plot(g, x, y, size);
        }
    }

    public void paint(Graphics g, int x, int y, Color c) {
        Color previousColor = g.getColor();
        g.setColor(c);
        g.fillRect(x, y, 1, 1);
        g.setColor(previousColor);
    }

    public void drawPolygon(Graphics g, int[] xPloy, int[] yPoly, Color lineColor, Color areaColor) {
        Polygon ploy = new Polygon(xPloy, yPoly, xPloy.length);
        g.setColor(areaColor);
        g.fillPolygon(ploy);
        g.setColor(lineColor);
        g.drawPolygon(ploy);
    }

    public void line(Graphics g, int x1, int y1, int x2, int y2, int size) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;
        boolean isSwap = false;

        if (dy > dx) {
            int temp = dy;
            dy = dx;
            dx = temp;
            isSwap = true;
        }

        int D = 2 * dy - dx;

        int x = x1;
        int y = y1;

        for (int i = 0; i < dx; i++) {
            plot(g, x, y, size);
            if (D >= 0) {
                if (isSwap)
                    x += sx;
                else
                    y += sy;

                D -= 2 * dx;
            }

            if (isSwap)
                y += sy;
            else
                x += sx;

            D += 2 * dy;
        }
    }

    public void drawTriangle(Graphics g, int xStart, int yStart, int xCenter, int yCenter, int xEnd, int yEnd, int size) {
        line(g, xStart, yStart, xCenter, yCenter, size);
        line(g, xCenter, yCenter, xEnd, yEnd, size);
    }

    public void bezierCurve(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int plot) {
        int x, y;

        for (int i = 0; i < 1000; i++) {

            double t = i / 1000.0;

            x = (int) (Math.pow((1 - t), 3) * x1 +
                    3 * t * Math.pow((1 - t), 2) * x2 +
                    3 * t * t * (1 - t) * x3 +
                    Math.pow(t, 3) * x4);

            y = (int) (Math.pow((1 - t), 3) * y1 +
                    3 * t * Math.pow((1 - t), 2) * y2 +
                    3 * t * t * (1 - t) * y3 +
                    Math.pow(t, 3) * y4);

            plot(g, x, y, plot);
        }
    }

    public BufferedImage floodFill(BufferedImage m, int x, int y, Color replacement_colour) {

        int target = m.getRGB(x, y);
        int replacement = replacement_colour.getRGB();
        return floodFill(m, x, y, target, replacement);
    }

    public BufferedImage floodFill(BufferedImage m, int x, int y, int target_colour, int replacement) {

        class Node {
            int x;
            int y;

            Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        Color replacement_colour = new Color(replacement);

        Queue<Node> q = new LinkedList<Node>();
        Graphics g = m.getGraphics();
        paint(g, x, y, replacement_colour);
        q.add(new Node(x, y));
        while (!q.isEmpty()) {

            Node currNode = q.remove();
            int currX = currNode.x;
            int currY = currNode.y;

            int north = m.getRGB(currX, currY - 1);
            int east = m.getRGB(currX + 1, currY);
            int west = m.getRGB(currX - 1, currY);
            int south = m.getRGB(currX, currY + 1);

            if (north == target_colour) {

                paint(g, currX, currY - 1, replacement_colour);
                q.add(new Node(currX, currY - 1));

            }
            if (east == target_colour) {

                paint(g, currX + 1, currY, replacement_colour);
                q.add(new Node(currX + 1, currY));

            }
            if (west == target_colour) {

                paint(g, currX - 1, currY, replacement_colour);
                q.add(new Node(currX - 1, currY));

            }
            if (south == target_colour) {

                paint(g, currX, currY + 1, replacement_colour);
                q.add(new Node(currX, currY + 1));

            }
        }
        return m;
    }

    public void fillColor(BufferedImage buffer, String csvFile) {
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int x = Integer.parseInt(data[0]);
                int y = Integer.parseInt(data[1]);
                Color color = MyColor.colorMapper(data[2]);

                floodFill(buffer, x, y, color);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
