package com.DawnDream.Labyrinth.api;

public class Auto {
    public static boolean a[][] , v[][];
    public static int startX , startY , endX , endY , step = 0 , min = 99999999;
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

        if (dx == endX && dy == endY) {
            if (step < min) {
                min = step;
                return;
            }
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

    public int getMin(){
        return min;
    }
}
