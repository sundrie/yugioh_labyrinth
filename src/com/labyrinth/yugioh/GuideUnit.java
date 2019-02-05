package com.labyrinth.yugioh;

import javax.swing.*;
import java.awt.*;

public class GuideUnit extends JPanel {
    Unit targetUnit;
    int[][] guideGrid;
    int w;
    int h;


    public GuideUnit(Unit unit, int[][] guideGridPos,int width, int height){
        targetUnit = unit;
        guideGrid = guideGridPos;

        // Permets de mettre le JPanel en transparent
        setOpaque(false);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.fillRect(300,300,200,200);
    }
}