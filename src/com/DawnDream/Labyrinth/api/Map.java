package com.DawnDream.Labyrinth.api;

public class Map {
    private int[][] map;
    public Map(int map[][]){
        this.map = map;
    }
    public boolean hasRoad(int X , int Y){
        return map[X][Y] == 1;
    }
}
