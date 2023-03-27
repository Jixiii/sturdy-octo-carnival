package homework2;

import java.awt.*;

/**
 * @author IDK You Yet
 */
public class MyRectangle implements MyGraphics, HavingArea {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public MyRectangle(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public MyRectangle(int x, int y, int width, int height) {
        this(x, y, width, height, Color.BLACK);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawRect(x, y, width, height);
    }

    @Override
    public double getArea() {
        return width * height;
    }
}