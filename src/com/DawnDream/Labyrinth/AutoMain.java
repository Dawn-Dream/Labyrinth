package com.DawnDream.Labyrinth;

import com.DawnDream.Labyrinth.api.Auto;
import com.DawnDream.Labyrinth.api.Labyrinth;
import com.DawnDream.Labyrinth.api.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author DawnDream
 * */
public class AutoMain {
    private static int L = 10;
    private static int in_x , in_y , out_x , out_y;
    public static void main(String[] args) {
        Labyrinth labyrinth = new Labyrinth(L ,1);
        int m[][] = labyrinth.getMap();
        boolean map[][] = new boolean[L + 1][L + 1];
        for (int i = 0; i <= L - 1; i++) {
            for (int j = 0; j <= L- 1; j++) {
                switch (m[j][i]){
                    case 1:
                        map[j][i] = true;
                        break;
                    case 2:
                        map[j][i] = true;
                        in_x = i;
                        in_y = j;
                        break;
                    case 3:
                        map[j][i] = true;
                        out_x = i;
                        out_y = j;
                        break;
                    default:
                        map[j][i] = false;
                }
            }
        }
        Auto auto = new Auto(map , in_x , in_y , out_x , out_y);
        System.out.println("---------------\n");
        int size = auto.getMinLocation().getSize() - 1;
        for (int i = 0; i <= size; i++) {
            System.out.println("[" + auto.getMinLocation().popX() + " " + auto.getMinLocation().popY() + "]");
        }
    }
}