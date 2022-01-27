package com.DawnDream.Labyrinth.api;

import java.util.Date;
import java.util.Random;

import static java.lang.Math.abs;
import static java.lang.Math.random;

public class Labyrinth {
    private static int L , RANK , WALL = 0 , ROUTE = 1;
    public int map[][];
    public Labyrinth(int l , int rank){
        L = l;
        RANK = rank;
        map = new int[L][L];
    }

    private void createLabyrinth(int StartX , int StartY){
        map[StartX][StartY] = ROUTE;
        int Direction[][] = {
                { 1,0 },
                { -1,0 },
                { 0,1 },
                { 0,-1 } };
        
        for (int i = 0; i < 4; i++) {
            int r = (int) (Math.random() * 10) % 4;
            int temp = Direction[0][0];
            Direction[0][0] = Direction[r][0];
            Direction[r][0] = temp;

            temp = Direction[0][1];
            Direction[0][1] = Direction[r][1];
            Direction[r][1] = temp;
        }
        for (int i = 0; i < 4; i++) {
            int dx = StartX;
            int dy = StartY;

            int range = 1 + (RANK == 0 ? 0 : new Random(new Date().getTime()).nextInt() % RANK);
            while (range>0) {
                dx += Direction[i][0];
                dy += Direction[i][1];

                if (map[dx][dy] == ROUTE) {
                    break;
                }

                int count = 0;
                for (int j = dx - 1; j < dx + 2; j++) {
                    for (int k = dy - 1; k < dy + 2; k++) {
                        //abs(j - dx) + abs(k - dy) == 1 确保只判断九宫格的四个特定位置
                        if (abs(j - dx) + abs(k - dy) == 1 && map[j][k] == ROUTE) {
                            count++;
                        }
                    }
                }

                if (count > 1) {
                    break;
                }

                --range;
                map[dx][dy] = ROUTE;
            }

            if (range <= 0) {
                createLabyrinth(dx , dy);
            }
        }
    }
    public int[][] getMap(){



        for (int i = 0; i < L; i++) {
            map[i][0] = 1;
        }
        for (int i = 0; i < L; i++){
            map[i][0] = ROUTE;
            map[0][i] = ROUTE;
            map[i][L - 1] = ROUTE;
            map[L - 1][i] = ROUTE;
        }

        for (int i = L - 3; i >= 0; i--) {
            if (map[i][L - 3] == ROUTE) {
                map[i][L - 2] = ROUTE;
                break;
            }
        }
        createLabyrinth(2 , 2);
        map[2][2] = 2;
        map[L-3][L-3] = 3;
        return map;
    }

}