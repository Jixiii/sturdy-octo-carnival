package minesweeper.tools;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * @author IDK You Yet
 */
public class StaticTool {
    public static int allcount = 10;

    public static Icon[] num = new Icon[10];
    public static Icon[] time = new Icon[11];

    public static Icon iconBlank = new ImageIcon("./image/blank.gif");
    public static Icon bloodIcon = new ImageIcon("./image/blood.gif");
    public static Icon smileIcon = new ImageIcon("./image/face0.gif");
    public static Icon faultFaceIcon = new ImageIcon("./image/face3.gif");
    public static Icon winFaceIcon = new ImageIcon("./image/face4.gif");
    public static Icon flagIcon = new ImageIcon("./image/flag.gif");

    static {
        for (int i = 0; i < num.length; i++) {
            num[i] = new ImageIcon("./image/" + i + ".gif");
        }
        for (int j = 0; j <= num.length; j++) {
            time[j] = new ImageIcon("./image/d" + j + ".gif");
        }
    }
}