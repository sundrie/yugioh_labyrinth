package com.labyrinth.yugioh;

import javax.swing.*;
import java.awt.*;

public class GuideUnitPanel extends JPanel {
    Unit targetUnit;
    GamePanel gPanel;
    int[][] guideGrid;
    int w;
    int h;


    public GuideUnitPanel(GamePanel gamePanel, int width, int height){
        gPanel = gamePanel;
//        targetUnit = unit;
//        guideGrid = guideGridPos;
        w = width;
        h = height;

        // Permets de mettre le JPanel en transparent
        setOpaque(false);
//        System.out.println(guideGrid[0][0]+" - "+guideGrid[0][1]);
//        System.out.println(guideGrid[1][0]+" - "+guideGrid[1][1]);
    }

    public void setUnit(){

    }

    public void setGrid(int[][] grid){
        guideGrid = grid;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        // Pour avoir un rouge transparent
        g.setColor(new Color(255,0,0, 80));

        // Peint le rectangle du haut
        g.fillRect(guideGrid[1][0],guideGrid[1][1],gPanel.tSize,gPanel.tSize);
        // Peint le rectangle de droite
        g.fillRect(guideGrid[2][0],guideGrid[2][1],gPanel.tSize,gPanel.tSize);
        // Peint le rectangle du bas
        g.fillRect(guideGrid[3][0],guideGrid[3][1],gPanel.tSize,gPanel.tSize);
        // Peint le rectangle de gauche
        g.fillRect(guideGrid[4][0],guideGrid[4][1],gPanel.tSize,gPanel.tSize);
    }

    public void test(GuideTiles guidee){
        add(guidee);
    }

    public class GuideTiles extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            System.out.println("toto");
        }
    }

}