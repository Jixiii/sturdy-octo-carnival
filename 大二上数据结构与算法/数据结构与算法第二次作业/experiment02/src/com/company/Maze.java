package com.company;

import java.io.*;

public class Maze {
    private int size;
    private boolean[][] map = new boolean[10000][10000];//墙表示为true，路表示为false
    private Player player = new Player(this);

    public Maze() {
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean[][] getMap() {
        return map;
    }

    public void setMap(boolean[][] map) {
        this.map = map;
    }

    void inputMap(String filename) {
        Reader reader = null;
        try {
            reader = new FileReader(filename);
            int characterNumber = 0;

            //设置size
            int number = 0;
            while ((char) (characterNumber = reader.read()) != '\n') {
                number *= 10;
                number += characterNumber - (int) '0';
            }
            number = (number - (int) '\n' + (int) '0') / 10;
            setSize(number);

            //设置x
            number = 0;
            while ((char) (characterNumber = reader.read()) != ' ') {
                number *= 10;
                number += characterNumber - (int) '0';
            }
            player.setX(number);

            //设置y
            number = 0;
            while ((char) (characterNumber = reader.read()) != '\n') {
                number *= 10;
                number += characterNumber - (int) '0';
            }
            number = (number - (int) '\n' + (int) '0') / 10;
            player.setY(number);

            //设置DestinationX
            number = 0;
            while ((char) (characterNumber = reader.read()) != ' ') {
                number *= 10;
                number += characterNumber - (int) '0';
            }
            player.setDestinationX(number);

            //设置DestinationY
            number = 0;
            while ((char) (characterNumber = reader.read()) != '\n') {
                number *= 10;
                number += characterNumber - (int) '0';
            }
            number = (number - (int) '\n' + (int) '0') / 10;
            player.setDestinationY(number);

            //设置地图
            for (int y = 0; y < size; y++) {
                for (int x = 0; x < size; x++) {
                    if ((char) (characterNumber = reader.read()) == '■') {
                        map[y][x] = true;
                    } else {
                        map[y][x] = false;
                    }
                }
                characterNumber = reader.read();
                characterNumber = reader.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void showMap() {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (map[y][x]) {
                    System.out.print('■');
                } else {
                    System.out.print('○');
                }
            }
            System.out.println();
        }
    }

    boolean isUnreachable(int x, int y) {
        if (x<0||y<0||x>=size||y>=size){
            return true;
        }else {
            return map[y][x];
        }
    }
}