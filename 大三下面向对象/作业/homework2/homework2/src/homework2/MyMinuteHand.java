package homework2;

import java.awt.*;

/**
 * @author IDK You Yet
 */
public class MyMinuteHand extends MyLine{
    public MyMinuteHand(int x, int y, int diameter, MyTime time, Color color) {
        super(x+diameter/2,y+diameter/2,
                x+diameter/2+(int)(diameter*Math.sin((time.minute*60+time.second)/
                        (30*60.0)*Math.PI)*0.35),
                x+diameter/2-(int)(diameter*Math.cos((time.minute*60+time.second)/
                        (30*60.0)*Math.PI)*0.35),color);

    }
    public MyMinuteHand(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
    }
}