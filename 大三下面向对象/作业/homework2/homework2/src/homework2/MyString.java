package homework2;

import java.awt.*;

/**
 * @author IDK You Yet
 */
public class MyString implements MyGraphics {
    private int x;
    private int y;
    private String string;
    private Color color;

    public MyString(int x, int y, String string, Color color) {
        this.x = x;
        this.y = y;
        this.string = string;
        this.color = color;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawString(string, x, y);
    }
}