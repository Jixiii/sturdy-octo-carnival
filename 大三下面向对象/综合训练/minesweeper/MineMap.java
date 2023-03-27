package minesweeper;

/** 这个类主要用来存储地雷在单元格中的位置，目前这个类只是一个示意，所以地雷都是固定位置。 */
public class MineMap {
    int numMines;
    boolean[][] isMined = new boolean[GameBoardPanel.ROWS][GameBoardPanel.COLS];
    public MineMap(){}
    public void newMineMap(int numMines){
        this.numMines = numMines;
        //此示例固定了地雷的数量为10，而且硬编码将地雷固定到固定位置处。
        isMined[0][0] = true;
        isMined[5][2] = true;
        isMined[9][5] = true;
        isMined[6][7] = true;
        isMined[8][2] = true;
        isMined[2][4] = true;
        isMined[5][7] = true;
        isMined[7][7] = true;
        isMined[3][6] = true;
        isMined[4][8] = true;
    }
}
