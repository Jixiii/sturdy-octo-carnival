package homework2;

import java.awt.Color;
import javax.swing.JFrame;
import java.util.Random;

public class TestDraw {
	public static void main(String[] args) {
		DrawPanel panel = new DrawPanel(generateLines());
		JFrame application = new JFrame();
		application.setTitle("面向对象程序设计第2次作业");
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.add(panel);
		application.setSize(400, 300);
		application.setVisible(true);
	}
	public static MyLine[] generateLines(){
		Random randomNumber = new Random();
		MyLine[] lines;
		lines = new MyLine[ 5 + randomNumber.nextInt(5)];
		for (int count = 0; count < lines.length; count++)
		{
			int x1 = randomNumber.nextInt(400);
			int y1 = randomNumber.nextInt(300);
			int x2 = randomNumber.nextInt(400);
			int y2 = randomNumber.nextInt(300);
			Color color = new Color( randomNumber.nextInt(256), randomNumber.nextInt(256), 
					randomNumber.nextInt(256));
			lines[count] = new MyLine(x1, y1, x2, y2, color);
		}
		return lines;
	}

}
