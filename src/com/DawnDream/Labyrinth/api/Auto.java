package com.DawnDream.Labyrinth.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Auto {
    public static boolean a[][] , v[][];
    public static int startX , startY , endX , endY , step = 0 , min = 99999999;
    public static Map<Integer, Location> location = new HashMap();
    public Location nowLocation = new Location();

    /**
     * 构造函数
     * @param aMap   权重地图
     * @param in_x   起始点X
     * @param in_y   起始点Y
     * @param out_x  终点X
     * @param out_y  终点Y
     *
     * aMap ->  TRUE == 空地 || FALSE == 墙
     * */
    public Auto(boolean aMap[][] , int in_x , int in_y , int out_x , int out_y){
        //二维数组特性 [实际Y][实际X]
        startX = in_y;
        startY = in_x;
        endX = out_y;
        endY = out_x;
        a = aMap;
        v = new boolean[a.length][a[0].length];
        for(boolean[] vj : v){
            for (boolean vi : vj){
                vi = false;
            }
        }
        auto(in_x , in_y , 0);
    }

    /**
     * 深搜主体
     * */
    private void auto(int dx , int dy , int step){
        v[dx][dy] = true;
        nowLocation.push(dx , dy);
        System.out.println(dx + " " + dy);
        if (dx == endX && dy == endY) {
            if (step < min) {
                min = step;
                location.put(step , nowLocation);
                System.out.println(step);
            }
            nowLocation.popX();
            nowLocation.popY();
            return;
        }

        int y[] = {1 , 0 , -1 , 0} , x[] = {0 , 1 , 0 , -1};
        for (int i = 0 ; i <= 3 ; i ++){
            int nx = dx + x[i] , ny = dy + y[i];
            if (a[nx][ny] == true && v[nx][ny] == false) {
                v[nx][ny] = true;
                auto(nx , ny , step+1);
                v[nx][ny] = false;
            }
        }
    }

    /**
     * 获得最小步数
     * @return int
     * */
    public int getMin(){
        return min;
    }

    /**
     * 获得最小路径
     * @return Location
     * */
    public Location getMinLocation(){
        return location.get(min);
    }
}
