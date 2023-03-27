package minesweeper;

import minesweeper.tools.StaticTool;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * 这个类的作用就是充当“棋盘”
 *
 * @author IDK You Yet
 */
public class GameBoardPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    public Difficulty difficulty;

    public MineSweeperMain mineSweeperMain;

    boolean start = false;

    /**
     * 设定了“棋盘”中有多少个Cell对象
     */
    public int rows;
    public int cols;

    /**
     * 每一个Cell对象的尺寸大小，依次大小再去计算“棋盘”的大小
     */
    public static final int CELL_SIZE = 16;

    Cell[][] cells = new Cell[100][100];
    int numMines;
    int theNumberOfMinesFound;
    int theNumberOfFlags;
    int theNumberOfDigMines;

    public GameBoardPanel(Difficulty difficulty, MineSweeperMain main) {
        this.mineSweeperMain = main;
        this.difficulty = difficulty;
        switch (difficulty) {
            case INTERMEDIATE -> {
                rows = 16;
                cols = 16;
                numMines = 40;
            }
            case DIFFICULT -> {
                rows = 16;
                cols = 30;
                numMines = 99;
            }
            default -> {
                rows = 9;
                cols = 9;
                numMines = 10;
            }
        }

        super.setLayout(new GridLayout(rows, cols, 1, 1));

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                cells[row][col] = new Cell(row, col);
                super.add(cells[row][col]);
            }
        }

        // [TODO 3] 为所有的Cell单元对象创建一个共享的鼠标事件监听器
        CellMouseListener listener = new CellMouseListener(this);

        // [TODO 4] 通过下面的循环，将每个Cell对象的鼠标事件监听器对象设为listener
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                cells[row][col].addMouseListener(listener);
            }
        }
        super.setPreferredSize(new Dimension(CELL_SIZE * cols, CELL_SIZE * rows));
    }

    /**
     * 初始化一个新的游戏
     */
    public void newGame() {
        /* * 通过MineMap获得新游戏中的地雷数据的布局*/
        MineMap mineMap = new MineMap();
        mineMap.newMineMap(this, numMines);
        /* * 根据mineMap中的数据初始化每个Cell单元对象*/
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                cells[row][col].newGame(mineMap.isMined[row][col]);
            }
        }
        start = false;
        mineSweeperMain.statePanel.setNumber(numMines);
    }

    /**
     * 获得[srcRow, srcCol]Cell单元对象周围的8个邻居的地雷总数
     */
    private int getSurroundingMines(int srcRow, int srcCol) {
        int numMines = 0;
        for (int row = srcRow - 1; row <= srcRow + 1; ++row) {
            for (int col = srcCol - 1; col <= srcCol + 1; ++col) {
                if (row >= 0 && row < rows && col >= 0 && col < cols) {
                    if (cells[row][col].isMined) {
                        numMines++;
                    }
                }
            }
        }
        return numMines;
    }

    /**
     * 对[srcRow, srcCol]Cell单元对象执行挖雷操作
     * 如果该单元格对象中的标记的雷的数量为0，那么就自动递归对其周围8个邻居执行挖雷操作
     */
    private void revealCell(int srcRow, int srcCol) {
        int numMines = getSurroundingMines(srcRow, srcCol);
        cells[srcRow][srcCol].setIcon(StaticTool.num[numMines]);
        cells[srcRow][srcCol].isRevealed = true;
        theNumberOfDigMines++;
        cells[srcRow][srcCol].paint();
        if (numMines == 0) {
            for (int row = srcRow - 1; row <= srcRow + 1; ++row) {
                for (int col = srcCol - 1; col <= srcCol + 1; ++col) {
                    if (row >= 0 && row < rows && col >= 0 && col < cols) {
                        if (!cells[row][col].isRevealed) {
                            revealCell(row, col);
                        }
                    }
                }
            }
        }
    }

    /**
     * 用来判断玩家是否已经赢得此次游戏
     */
    public void hasWon() {
        // 如果将所有单元格都成功执行了挖雷操作或者所有的地雷都被标记
        boolean hasWon = false;
        if (numMines == theNumberOfMinesFound && theNumberOfMinesFound == theNumberOfFlags) {
            hasWon = true;
        } else if ((theNumberOfDigMines + numMines) == rows * cols) {
            hasWon = true;
        }
        if (hasWon) {
            mineSweeperMain.statePanel.timer.stop();
            mineSweeperMain.statePanel.labelFace.setIcon(StaticTool.winFaceIcon);
            System.out.println("Won!");
            String message[] = {"是", "否"};
            int choose = JOptionPane.showOptionDialog(null,
                    "恭喜挑战成功！\n是否重新挑战?", "提示",
                    JOptionPane.YES_OPTION, JOptionPane.NO_OPTION, null,
                    message, message[0]);
            if (choose == 0) {
                new MineSweeperMain(difficulty);
                mineSweeperMain.setVisible(false);
                mineSweeperMain.dispose();
            } else {
                System.exit(0);
            }
        }
    }

    /**
     * [TODO 2] 定义一个内部类，该类的作用为鼠标事件监听器
     */
    private class CellMouseListener extends MouseAdapter {
        GameBoardPanel gameBoardPanel;

        public CellMouseListener(GameBoardPanel gameBoardPanel) {
            this.gameBoardPanel = gameBoardPanel;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            Cell sourceCell = (Cell) e.getSource();
            if (!start) {
                start = true;
                mineSweeperMain.statePanel.firstClickTime();
            }
            // 获得鼠标事件的类型，MouseEvent.BUTTON1为单击鼠标左键
            if (e.getButton() == MouseEvent.BUTTON1)
            /** [TODO 5] 如果当前Cell对象里面有地雷，则游戏结束；否则对该Cell对象执行挖雷操作*/ {
                if (sourceCell.isMined) {
                    mineSweeperMain.statePanel.timer.stop();
                    mineSweeperMain.statePanel.labelFace.setIcon(StaticTool.faultFaceIcon);
                    System.out.println("Game Over");
                    start = false;
                    sourceCell.setIcon(StaticTool.bloodIcon);
                    String message[] = {"是", "否"};//创建一个数组并用于自定义提示框
                    int choose = JOptionPane.showOptionDialog(null,
                            "挑战失败!\n是否重新挑战?", "提示", JOptionPane.YES_OPTION,
                            JOptionPane.NO_OPTION, null, message, message[0]);
                    if (choose == 0) {
                        new MineSweeperMain(difficulty);
                        mineSweeperMain.dispose();
                    } else {
                        System.exit(0);
                    }
                } else {
                    revealCell(sourceCell.row, sourceCell.col);
                }
            } else if (e.getButton() == MouseEvent.BUTTON3) { //MouseEvent.BUTTON3为单击鼠标右键
                // [TODO 6] 如果该Cell对象上插了旗子，那么就去掉旗子；否则将该Cell对象打上旗子的标记。
                sourceCell.isFlagged = !sourceCell.isFlagged;
                sourceCell.setIcon(sourceCell.isFlagged ? StaticTool.flagIcon : StaticTool.iconBlank);
                if (sourceCell.isFlagged) {
                    gameBoardPanel.theNumberOfFlags++;
                    if (sourceCell.isMined) {
                        gameBoardPanel.theNumberOfMinesFound++;
                    }
                } else {
                    gameBoardPanel.theNumberOfFlags--;
                    if (sourceCell.isMined) {
                        gameBoardPanel.theNumberOfMinesFound--;
                    }
                }
                DeBug.p(theNumberOfFlags + "  " + theNumberOfMinesFound);
                mineSweeperMain.statePanel.setNumber(numMines - theNumberOfFlags);
            }
            // [TODO 7] 当对Cell单元格对象执行了挖雷操作之后判断玩家是否赢得该游戏
            gameBoardPanel.hasWon();
        }
    }
}