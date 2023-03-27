package minesweeper;

import java.util.Random;

/**
 * 这个类主要用来存储地雷在单元格中的位置，目前这个类只是一个示意，所以地雷都是固定位置。
 * @author IDK You Yet
 */
public class MineMap {
    int numMines;
    boolean[][] isMined;

    public MineMap() {
    }

    public void newMineMap(GameBoardPanel gameBoardPanel,int numMines) {
        isMined = new boolean[gameBoardPanel.rows][gameBoardPanel.cols];
        this.numMines = numMines;
        int numberOfMinesPresent = 0;
        while (numberOfMinesPresent < numMines) {
            Random random = new Random();
            int x = random.nextInt(gameBoardPanel.rows);
            int y = random.nextInt(gameBoardPanel.cols);
            if (!isMined[x][y]) {
                isMined[x][y] = true;
                numberOfMinesPresent++;
            }
        }
    }
}