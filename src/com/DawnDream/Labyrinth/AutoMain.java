package com.DawnDream.Labyrinth;

import com.DawnDream.Labyrinth.api.Auto;

public class AutoMain {
    public static void main(String[] args) {
        boolean map[][] = {
                {false , false , false , false , false},
                {false , true  , false , true  , false},
                {false , true  , true  , true  , false},
                {false , true  , false , true  , true  , false},
                {false , true  , true  , true  , false},
                {false , false , false , false , false}};
        Auto auto = new Auto(map , 1 , 1  , 4 ,  3);
        System.out.println(auto.getMin());
    }
}
