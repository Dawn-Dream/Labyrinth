package com.DawnDream.Labyrinth;

import com.DawnDream.Labyrinth.api.Labyrinth;
import com.DawnDream.Labyrinth.api.Map;

import java.awt.*;
import java.awt.event.*;

/**
 * @author DawnDream
 * @create 2022.1.23
 * @desc
 **/

public class PlayMain {

    public static int StartX = 2 , StartY = 2 , L = 10;
    public static int nowX = 0 , nowY = 0;
    public static int nowMap[][];
    public static Paint myPaint;
    public static void main(String[] args) {
        Labyrinth labyrinth = new Labyrinth(L ,1);
        int m[][] = nowMap = labyrinth.getMap();
        myPaint = new Paint(m , L , L , 900/L);
        nowX = StartX;
        nowY = StartY;
        myPaint.loadFrame();
        windowClose(myPaint);
    }

    private static void windowClose(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class Paint extends Frame {
    private static int map[][] , w , h , L;

    public Paint(int m[][],int width , int height , int L){
        map = m;
        w = width;
        h = height;
        this.L = L;
    }

    @Override
    public void paint(Graphics g) {
        for (int j = 0 ; j <= h - 1 ; j++){
            for (int i = 0 ; i <= w - 1 ; i++){
                if (map[j][i] == 0){
                    /** WALL : 0**/
                    g.setColor(Color.BLACK);
                    g.fillRect(50 + (i * L) , 50 + (j * L) , L ,L);
                }else if (map[j][i] == 1){
                    /** ROAD : 1**/
                    g.setColor(Color.WHITE);
                    g.fillRect(50 + (i * L) , 50 + (j * L) , L ,L);
                }else if (map[j][i] == 2){
                    g.setColor(Color.RED);
                    g.fillRect(50 + (i * L) , 50 + (j * L) , L ,L);
                }else if (map[j][i] == 3){
                    g.setColor(Color.GREEN);
                    g.fillRect(50 + (i * L) , 50 + (j * L) , L ,L);
                }
            }
        }
    }

    public void loadFrame() {
        setBounds(500, 50, 1000, 1000);
        setTitle("awa");
        setVisible(true);
        setResizable(false);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int X = PlayMain.nowX , Y = PlayMain.nowY;
                switch (e.getKeyCode()){
                    case KeyEvent.VK_UP:
                    if (new Map(map).hasRoad(Y - 1 , X)){
                        PlayMain.nowY -= 1;
                        PlayMain.nowMap[Y][X] = 1;
                        PlayMain.nowMap[Y - 1][X] = 2;
                        new Paint(PlayMain.nowMap , PlayMain.L , PlayMain.L , 900/ PlayMain.L).paint(getGraphics());
                    }else{
                        //System.out.println("cant move to there!");
                    }
                    break;

                    case KeyEvent.VK_DOWN:
                    if (new Map(map).hasRoad(Y + 1 , X)){
                        PlayMain.nowY += 1;
                        PlayMain.nowMap[Y][X] = 1;
                        PlayMain.nowMap[Y + 1][X] = 2;
                        new Paint(PlayMain.nowMap , PlayMain.L , PlayMain.L , 900/ PlayMain.L).paint(getGraphics());
                    }else{
                        //System.out.println("cant move to there! " + X + "  " + (Y + 1));
                    }
                    break;

                    case KeyEvent.VK_LEFT:
                        if (new Map(map).hasRoad(Y , X - 1)){
                            PlayMain.nowX -= 1;
                            PlayMain.nowMap[Y][X] = 1;
                            PlayMain.nowMap[Y][X - 1] = 2;
                            new Paint(PlayMain.nowMap , PlayMain.L , PlayMain.L , 900/ PlayMain.L).paint(getGraphics());
                        }else{
                            //System.out.println("cant move to there!");
                        }
                        break;

                    case KeyEvent.VK_RIGHT:
                        if (new Map(map).hasRoad(Y , X + 1)){
                            PlayMain.nowX += 1;
                            PlayMain.nowMap[Y][X] = 1;
                            PlayMain.nowMap[Y][X + 1] = 2;
                            new Paint(PlayMain.nowMap , PlayMain.L , PlayMain.L , 900/ PlayMain.L).paint(getGraphics());
                        }else{
                            //System.out.println("cant move to there!");
                        }
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
}
