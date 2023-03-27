package homework2;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.io.Serial;

/**
 * @author IDK You Yet
 */
public class MyDrawPanel extends JPanel {

    @Serial
    private static final long serialVersionUID = 1L;

    private MyGraphics[] graphics;
    private final int type;

    private static final int NONE = 0;
    private static final int GRAPHICS = 1;
    private static final int NULL = 4;
    private static final int NOTARRAY = 5;

    public MyDrawPanel() {
        setBackground(Color.BLACK);
        type = NONE;
    }

    public MyDrawPanel(MyGraphics[] myGraphics) {
        setBackground(Color.WHITE);
        if (myGraphics == null) {
            type = NULL;
            return;
        }
        if (!myGraphics.getClass().isArray()) {
            type = NOTARRAY;
            return;
        }
        this.graphics = myGraphics;
        type = GRAPHICS;
    }

    public MyDrawPanel(MyTime myTime, int x, int y, int diameter) {
        setBackground(Color.WHITE);
        if (myTime == null) {
            type = NULL;
            return;
        }
        Color backgroundColor = new Color(97, 177, 198);
        int excursion = 15;
        graphics = new MyGraphics[8];
        this.graphics[0] = new MyCircle(x, y, diameter, backgroundColor);
        this.graphics[1] = new MyString(x + diameter / 2, y + excursion,
                "12", backgroundColor);
        this.graphics[2] = new MyString(x + diameter - excursion, y + diameter / 2,
                "3", backgroundColor);
        this.graphics[3] = new MyString(x + diameter / 2, y + diameter - excursion / 3,
                "6", backgroundColor);
        this.graphics[4] = new MyString(x + excursion / 3, y + diameter / 2,
                "9", backgroundColor);
        this.graphics[5] = new MyHourHand(x, y, diameter, myTime, Color.GREEN);
        this.graphics[6] = new MyMinuteHand(x, y, diameter, myTime, Color.BLUE);
        this.graphics[7] = new MySecondHand(x, y, diameter, myTime, Color.RED);
        type = GRAPHICS;
    }

    public MyDrawPanel(MyTime time) {
        this(time, 30, 30, 400);
    }

    public void updateTime(MyTime myTime) {
        updateTime(myTime, 30, 30, 400);
    }

    public void updateTime(MyTime myTime, int x, int y, int diameter) {
        this.graphics[5] = new MyHourHand(x, y, diameter, myTime, Color.GREEN);
        this.graphics[6] = new MyMinuteHand(x, y, diameter, myTime, Color.BLUE);
        this.graphics[7] = new MySecondHand(x, y, diameter, myTime, Color.RED);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch (type) {
            case NULL:
                g.drawString("在DrawPanel的构造函数中，你传递的引用参数是NULL。",
                        50, 50);
                break;
            case NOTARRAY:
                g.drawString("在DrawPanel的构造函数中，你传递的引用参数必须是某个形状的数组类型。",
                        50, 50);
                break;
            case GRAPHICS:
                for (MyGraphics myGraphics : graphics) {
                    myGraphics.draw(g);
                }
                break;
            default:
                System.out.println("???");
        }
    }
}