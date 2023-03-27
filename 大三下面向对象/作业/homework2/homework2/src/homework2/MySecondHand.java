package homework2;
import java.awt.*;
/**
 * @author IDK You Yet
 */
public class MySecondHand extends MyLine{
    public MySecondHand(int x, int y, int diameter, MyTime time, Color color) {
        super(x+diameter/2,y+diameter/2,
                x+diameter/2+(int)(diameter*Math.sin((time.second/30.0)*Math.PI)*0.45),
                x+diameter/2-(int)(diameter*Math.cos((time.second/30.0)*Math.PI)*0.45),color);

    }
    public MySecondHand(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
    }
}