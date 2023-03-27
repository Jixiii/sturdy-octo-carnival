package homework2;

import java.awt.*;

/**
 * @author IDK You Yet
 */
public class MyHourHand extends MyLine {
    public MyHourHand(int x, int y, int diameter, MyTime time, Color color) {
        super(x+diameter/2,y+diameter/2,
                x+diameter/2+(int)(diameter*Math.sin((time.hour*60*60+time.minute*60+time.second)/
                        (6*60*60.0)*Math.PI)*0.25),
                x+diameter/2-(int)(diameter*Math.cos((time.hour*60*60+time.minute*60+time.second)/
                        (6*60*60.0)*Math.PI)*0.25),color);

    }

    public MyHourHand(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
    }
}