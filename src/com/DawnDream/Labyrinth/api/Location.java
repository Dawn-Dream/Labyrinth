package com.DawnDream.Labyrinth.api;

import java.util.Stack;


/**
 * @author DawnDream
 * <p>x y记得同时出栈！！！</p>
 * */
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
        System.out.println("XY:我进了");
        X.push(x);
        Y.push(y);
    }

    /**
     * x坐标出栈
     * @return 如果空则输出0
     * */
    public Integer popX(){
        if (!X.empty()){
            System.out.println("X:我出了");
            return X.pop();
        }else return 0;
    }

    /**
     * y坐标出栈
     * @return 如果空则输出0
     * */
    public Integer popY(){
        if (!Y.empty()){
            System.out.println("Y:我出了");
            return Y.pop();
        }else return 0;
    }

    /**
     * 获取栈的大小
     * @return int
     * */
    public int getSize(){
        System.out.println(Y.size());
        return Y.size();
    }
}
