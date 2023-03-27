package homework2;
import java.awt.Graphics;
import java.awt.Color;
/**
 * @author IDK You Yet
 */
public class MyLine implements MyGraphics {
	private final int x1;
	private final int y1;
	private final int x2;
	private final int y2;
	private final Color color;

	public MyLine(int x1, int y1, int x2, int y2, Color color)
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color; 
	}

	@Override
	public void draw(Graphics g)
	{
		g.setColor(color);
		g.drawLine(x1, y1, x2, y2);
	}
}