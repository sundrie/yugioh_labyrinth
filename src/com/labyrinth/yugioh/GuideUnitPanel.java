package com.labyrinth.yugioh;

import javax.swing.*;
import java.awt.*;

public class GuideUnitPanel extends JPanel {
    Unit targetUnit;
    GamePanel gPanel;
    int[][] guideGrid;
    int w;
    int h;


    public GuideUnitPanel(Unit unit, int[][] guideGridPos, GamePanel gamePanel, int width, int height){
        gPanel = gamePanel;
        targetUnit = unit;
        guideGrid = guideGridPos;
        w = width;
        h = height;

        // Permets de mettre le JPanel en transparent
        setOpaque(false);
        System.out.println(guideGrid[0][0]+" - "+guideGrid[0][1]);
        System.out.println(guideGrid[1][0]+" - "+guideGrid[1][1]);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.red);

        // Peint le rectangle du haut
        g.fillRect(guideGrid[0][0],guideGrid[1][1],gPanel.tSize,gPanel.tSize);
    }
}