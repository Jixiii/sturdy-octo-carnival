package minesweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 挖雷游戏的主程序。
 * 单击鼠标左键对单元格执行挖雷操作。
 * 单击鼠标右键用来对单元格执行添加标记，或者移除标记，标记疑似有地雷的单元格。
 * 如果所有没有地雷的单元格都执行了挖雷操作，那么玩家赢得游戏。
 * 如果对某个有地雷的单元格执行了挖雷操作，那么玩家输。
 *
 * @author IDK You Yet
 */
public class MineSweeperMain extends JFrame {
    private static final long serialVersionUID = 1L;
    StatePanel statePanel = new StatePanel(this);

    GameBoardPanel board;

    public MineSweeperMain(Difficulty difficulty) {
        board = new GameBoardPanel(difficulty, this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar JMB = new JMenuBar();//创建菜单栏
        setJMenuBar(JMB);//设置菜单栏(添加)
        JMenu JM_File = new JMenu("File");//创建一个菜单
        JMB.add(JM_File);//添加到菜单栏
        JMenuItem JMI_New = new JMenuItem("New Game");//创建一个菜单项
        JMI_New.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameInitFrame();
                setVisible(false);
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        JM_File.add(JMI_New);//添加到菜单

        JMenuItem JMI_Reset = new JMenuItem("Reset Game");//创建一个菜单项
        JMI_Reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MineSweeperMain(difficulty);
                setVisible(false);
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        JM_File.add(JMI_Reset);//添加到菜单

        JMenuItem JMI_Exit = new JMenuItem("Exit");//创建一个菜单项
        JMI_Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a[] = {"是", "否"};//创建一个数组并用于自定义提示框
                int b = JOptionPane.showOptionDialog(null,
                        "是否退出游戏?", "提示",
                        JOptionPane.YES_OPTION, JOptionPane.NO_OPTION,
                        null, a, a[0]);
                if (b == 0) {
                    System.exit(0);//退出系统
                }
            }
        });
        JM_File.add(JMI_Exit);//添加到菜单

        Container cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(statePanel, BorderLayout.NORTH);
        cp.add(board, BorderLayout.CENTER);
        board.newGame();
        pack(); // Pack the UI components, instead of setSize()
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Minesweeper");
        setVisible(true);
    }

    public static void main(String[] args) {
        // [TODO 1] 使用安全的方式启动下面的构造函数
        new GameInitFrame();
    }
}