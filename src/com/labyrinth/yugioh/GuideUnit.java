package com.labyrinth.yugioh;

import javax.swing.*;
import java.awt.*;

public class GuideUnit extends JPanel {
    Unit targetUnit;


    public GuideUnit(Unit unit, int[][] guideGridPos){
        targetUnit = unit;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);


    }
}
