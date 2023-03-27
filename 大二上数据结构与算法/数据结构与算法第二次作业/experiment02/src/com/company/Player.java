package com.company;

public class Player {
    private int x;
    private int y;
    private int destinationX;
    private int destinationY;
    private Maze maze;
    private Direction direction=Direction.LEFT;
    public MyStack records = new MyStack();

    public Player() {
        direction = Direction.LEFT;
    }

    public Player(Maze maze) {
        this.maze = maze;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDestinationX() {
        return destinationX;
    }

    public void setDestinationX(int destinationX) {
        this.destinationX = destinationX;
    }

    public int getDestinationY() {
        return destinationY;
    }

    public void setDestinationY(int destinationY) {
        this.destinationY = destinationY;
    }

    public Maze getMaze() {
        return maze;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void go(){
        try {
            while (x!=destinationX||y!=destinationY){
                move();                                             //move直到到达终点
            }
            records.push(new Position(destinationX,destinationY));  //将终点坐标压入栈中
            for (int i = 0; i < records.top; i++) {
                System.out.println(records.positions[i]);           //弹栈
            }
        }catch (NullPointerException e){
            System.out.println("no path");                          //如果出现异常，输出”no path“
        }
    }

    public void move() {
        records.push(new Position(x, y));
        maze.getMap()[y][x] = true;
        if (!maze.isUnreachable(x, y - 1)) {                //上
//            records.push(new Position(x, y - 1));
            y--;
//            maze.getMap()[y][x] = true;
        } else if (!maze.isUnreachable(x + 1, y)) {      //右
//            records.push(new Position(x + 1, y));
            x++;
//            maze.getMap()[y][x] = true;
        } else if (!maze.isUnreachable(x, y + 1)) {      //下
//            records.push(new Position(x, y + 1));
            y++;
//            maze.getMap()[y][x] = true;
        } else if (!maze.isUnreachable(x - 1, y)) {       //左
//            records.push(new Position(x - 1, y));
            x--;
//            maze.getMap()[y][x] = true;
        } else {
            Position tempPosition = records.pop();
            tempPosition = records.pop();
            x = tempPosition.x;
            y = tempPosition.y;
        }
    }
}
