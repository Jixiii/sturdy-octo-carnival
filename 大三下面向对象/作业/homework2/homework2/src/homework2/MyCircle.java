package homework2;

import java.awt.*;

public class MyCircle implements MyGraphics, HavingArea {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public MyCircle(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public MyCircle(int x, int y, int diameter, Color color) {
        this(x, y, diameter, diameter, color);
    }

    public MyCircle(int x, int y, int width, int height) {
        this(x, y, width, height, Color.BLACK);
    }

    public MyCircle(int x, int y, int diameter) {
        this(x, y, diameter, Color.BLACK);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawOval(x, y, width, height);
    }

    @Override
    public double getArea() {
        return Math.PI * width * height;
    }
}