import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.util.Random;

/**
 * @author IDK You Yet
 */
public class Homework006 {
    public int[] getRandom(int size){
        int[] result = new int[2];
        Random random = new Random();
        result[0] = random.nextInt(size);
        result[1] = random.nextInt(size);
        return result;
    }

    public int inWhichArea(int[] point,int size){
        if (point[0]<size>>1){
            return 1;
        }
        if (point[1]>size>>1){
            return 4;
        }
        if (point[0]-point[1]<size>>1){
            return 3;
        }
        return 2;
    }
}

class DrawPicture {
    public static void main(String[] args) {
        //初始化一个窗口
        JFrame frame = new JFrame("my frame");
        // 设置窗口大小
        frame.setSize(800, 800);
        // 设置画图结束后的操作：退出画图程序
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 显示窗口
        frame.setVisible(true);
        //重写 paint 方法
        JPanel panel = new JPanel() {      // 初始化一个新画布
            @Serial
            private static final long serialVersionUID = 1L;
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                int margin = 5;
                int size = 750;
                //画一个矩形
                g.drawRect(margin,margin,size,size);
                g.drawLine((size>>1)+margin,margin,(size>>1)+margin,size+margin);
                g.drawLine((size>>1)+margin,(size>>1)+margin,size+margin,(size>>1)+margin);
                g.drawLine((size>>1)+margin,margin,size+margin,(size>>1)+margin);
                //设置画笔颜色
                g.setColor(Color.BLUE);
                int repeatTimes = 100000;
                Homework006 work = new Homework006();
                int[] eachSum = new int[4];
                for (int i = 0; i < repeatTimes; i++) {
                    int [] point = work.getRandom(size);
                    eachSum[work.inWhichArea(point,size)-1]++;
                    g.drawLine(point[0]+margin,point[1]+margin,point[0]+margin,point[1]+margin);
                }
                int sum = 0;
                for (int i = 0; i < 4; i++) {
                    sum += eachSum[i];
                    System.out.println(eachSum[i]);
                }
                System.out.println((double)(eachSum[0]+eachSum[2])/sum);
            }
        };
        // 将画布添加到窗口中
        frame.setContentPane(panel);
    }
}