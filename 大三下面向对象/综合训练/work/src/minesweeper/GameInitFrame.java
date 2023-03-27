package minesweeper;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.Serial;

/**
 * 这个类的作用就是充当初始化界面，选择难度
 *
 * @author IDK You Yet
 */
public class GameInitFrame extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;

    JButton easy = new JButton("Easy");
    JButton intermediate = new JButton("Intermediate");
    JButton difficult = new JButton("Difficult");

    public GameInitFrame() {
        Container cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(easy, BorderLayout.NORTH);
        cp.add(intermediate, BorderLayout.CENTER);
        cp.add(difficult, BorderLayout.SOUTH);
        // 使用匿名类的方式为按钮添加Action事件监听器
        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                new MineSweeperMain(Difficulty.EASY);
                setVisible(false);
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        intermediate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                new MineSweeperMain(Difficulty.INTERMEDIATE);
                setVisible(false);
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        difficult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                new MineSweeperMain(Difficulty.DIFFICULT);
                setVisible(false);
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });

        pack(); // Pack the UI components, instead of setSize()
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GameInit");
        setVisible(true);
    }
}