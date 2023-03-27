package minesweeper;

import minesweeper.tools.StaticTool;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

/**
 * @author IDK You Yet
 */
public class StatePanel extends JPanel {

    Timer timer;
    long startTime = System.currentTimeMillis();

    MineSweeperMain mineSweeperMain;
    public JLabel labelTimeG = new JLabel();
    public JLabel labelTimeS = new JLabel();
    public JLabel labelTimeB = new JLabel();
    public JLabel labelCountG = new JLabel();
    public JLabel labelCountS = new JLabel();
    public JLabel labelCountB = new JLabel();
    public JLabel labelFace = new JLabel();

    public StatePanel(MineSweeperMain frame) {
        mineSweeperMain = frame;
        this.setLayout(new BorderLayout());
        init();
    }

    private void init() {
        JPanel panel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.LINE_AXIS);
        panel.setLayout(boxLayout);

        FaceLableListener faceLableListener;
        faceLableListener = new FaceLableListener();
        panel.addMouseListener(faceLableListener);

        Icon icon0 = new ImageIcon("./image/d0.gif");
        Icon icon1 = new ImageIcon("./image/d" + StaticTool.allcount / 10
                + ".gif");
        Icon icon2 = new ImageIcon("./image/d" + StaticTool.allcount % 10
                + ".gif");
        labelCountG.setIcon(icon2);
        labelCountS.setIcon(icon1);
        labelCountB.setIcon(icon0);
        labelTimeS.setIcon(icon0);
        labelTimeG.setIcon(icon0);
        labelTimeB.setIcon(icon0);
        labelFace.setIcon(StaticTool.smileIcon);
        panel.add(Box.createHorizontalStrut(2));
        panel.add(labelCountB);
        panel.add(labelCountS);
        panel.add(labelCountG);
        panel.add(Box.createHorizontalGlue());
        panel.add(labelFace);
        panel.add(Box.createHorizontalGlue());
        panel.add(labelTimeB);
        panel.add(labelTimeS);
        panel.add(labelTimeG);
        panel.add(Box.createHorizontalStrut(2));
        this.add(panel);

        Border borderLow = BorderFactory.createLoweredBevelBorder();

        Border borderEmpty = BorderFactory.createEmptyBorder(2, 2, 2, 2);
        Border borderCom1 = BorderFactory.createCompoundBorder(borderLow,
                borderEmpty);

        panel.setBorder(borderCom1);
        panel.setBackground(Color.LIGHT_GRAY);

        this.add(panel);
        Border borderEmpty2 = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        this.setBorder(borderEmpty2);
        this.setBackground(Color.LIGHT_GRAY);

//创建定时器每隔,每隔1000毫秒执行一次
        ActionListener task = new UpdateTask();
        timer = new Timer(1000, task);
    }

    public void setNumber(int count) {
        int b = 0;
        if (count < 0) {
            b = 10;
        } else {
            b = count / 100;
        }
        int g = Math.abs(count) % 10;
        int s = Math.abs(count) / 10 % 10;
        labelCountG.setIcon(StaticTool.time[g]);
        labelCountS.setIcon(StaticTool.time[s]);
        labelCountB.setIcon(StaticTool.time[b]);
    }

    public void setTime(int count) {
        int g = count % 10;
        int s = count / 10 % 10;
        int b = count / 100;
        labelTimeG.setIcon(StaticTool.time[g]);
        labelTimeS.setIcon(StaticTool.time[s]);
        labelTimeB.setIcon(StaticTool.time[b]);
    }

    public void firstClickTime() {
        startTime = System.currentTimeMillis();
        ActionListener task = new UpdateTask();
        timer = new Timer(1000, task);
        timer.start();
    }

    public class UpdateTask implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
            setTime((int) (System.currentTimeMillis() - startTime) / 1000);
        }
    }

    public class FaceLableListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            new MineSweeperMain(mineSweeperMain.board.difficulty);
            mineSweeperMain.dispose();
        }
    }
}