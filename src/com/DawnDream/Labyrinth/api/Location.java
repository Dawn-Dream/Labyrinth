package com.DawnDream.Labyrinth.api;

import java.util.Stack;

public class Location {

    public static Stack<Integer> X , Y;

    /**
     * 构造函数
     * */
    public Location(){
        X = new Stack<>();
        Y = new Stack<>();
    }
    /**
     * 坐标进栈
     * @param x x坐标
     * @param y y坐标
     * */
    public void push(Integer x , Integer y){
        X.push(x);
        Y.push(y);
    }

    /**
     * x坐标出栈
     * @return 如果空则输出0
     * */
    public Integer popX(){
        if (!X.empty()){
            return X.pop();
        }else return 0;
    }

    /**
     * y坐标出栈
     * @return 如果空则输出0
     * */
    public Integer popY(){
        if (!Y.empty()){
            return Y.pop();
        }else return 0;
    }
}
