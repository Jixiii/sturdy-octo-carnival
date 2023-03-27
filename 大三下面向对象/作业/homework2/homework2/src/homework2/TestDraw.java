package homework2;

import java.awt.Color;
import javax.swing.JFrame;
import java.util.Random;

public class TestDraw {
    static int windowWidth = 500;
    static int windowHeight = 500;

    public static void main(String[] args) {
        MyDrawPanel panelLine = new MyDrawPanel(generateLines());
        MyDrawPanel panelRectangle = new MyDrawPanel(generateRectangles());
        MyDrawPanel panelCircle = new MyDrawPanel(generateCircle());
        MyDrawPanel panelTest = new MyDrawPanel();
        JFrame application = new JFrame();
        application.setTitle("面向对象程序设计第2次作业");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panelTest);
        application.setSize(windowWidth, windowHeight);
        application.setVisible(true);
    }


    public static MyLine[] generateLines() {
        Random randomNumber = new Random();
        MyLine[] lines;
        lines = new MyLine[5 + randomNumber.nextInt(5)];
        for (int count = 0; count < lines.length; count++) {
            int x1 = randomNumber.nextInt(windowWidth);
            int y1 = randomNumber.nextInt(windowHeight);
            int x2 = randomNumber.nextInt(windowWidth);
            int y2 = randomNumber.nextInt(windowHeight);
            Color color = new Color(randomNumber.nextInt(256), randomNumber.nextInt(256),
                    randomNumber.nextInt(256));
            lines[count] = new MyLine(x1, y1, x2, y2, color);
        }
        return lines;
    }

    public static MyRectangle[] generateRectangles() {
        Random randomNumber = new Random();
        MyRectangle[] rectangles;
        rectangles = new MyRectangle[5 + randomNumber.nextInt(5)];
        for (int count = 0; count < rectangles.length; count++) {
            int x = randomNumber.nextInt(windowWidth/2);
            int y = randomNumber.nextInt(windowHeight/2);
            int width = randomNumber.nextInt(windowWidth - x);
            int height = randomNumber.nextInt(windowHeight - y);
            Color color = new Color(randomNumber.nextInt(256), randomNumber.nextInt(256),
                    randomNumber.nextInt(256));
            rectangles[count] = new MyRectangle(x, y, width, height, color);
        }
        return rectangles;
    }

    public static MyCircle[] generateCircle() {
        Random randomNumber = new Random();
        MyCircle[] circles;
        circles = new MyCircle[5 + randomNumber.nextInt(8)];
        for (int count = 0; count < circles.length; count++) {
            int x = randomNumber.nextInt(windowWidth);
            int y = randomNumber.nextInt(windowHeight);
            int diameter = randomNumber.nextInt(Math.min(windowWidth - x, windowHeight - y));
            Color color = new Color(randomNumber.nextInt(256), randomNumber.nextInt(256),
                    randomNumber.nextInt(256));
            circles[count] = new MyCircle(x, y, diameter, color);
        }
        return circles;
    }
}
