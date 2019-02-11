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
        // Par défaut il y a un margin à 5. On écrase ce 5 par 0 ainsi il n'y a plus de margins gênants
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
    }

    public void setUnit(){

    }

    public void setGrid(int[][] grid){
        guideGrid = grid;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

    // On ajoute un JPanel qui peindra sur demande les tiles de guide
    public void paintTiles(GuideTiles guideTiles){
        add(guideTiles);
        // On donne les mêmes dimensions aux 2 JPanels
        guideTiles.setPreferredSize(new Dimension(w,h));
        // Idem pour le rendre transparent
        guideTiles.setOpaque(false);
    }


    // Cette classe servira a peindre les guides
    public class GuideTiles extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
//            System.out.println("GuideTiles : "+guideGrid[2][0]+" "+guideGrid[2][1]);
            // Pour avoir un rouge transparent
            g.setColor(new Color(255,0,0, 80));
            // Peint le rectangle du haut
            g.fillRect(guideGrid[1][0],guideGrid[1][1],gPanel.tSize,gPanel.tSize);
            // Peint le rectangle du haut
            g.fillRect(guideGrid[2][0],guideGrid[2][1],gPanel.tSize,gPanel.tSize);
            // Peint le rectangle du haut
            g.fillRect(guideGrid[3][0],guideGrid[3][1],gPanel.tSize,gPanel.tSize);
            // Peint le rectangle de gauche
            g.fillRect(guideGrid[4][0],guideGrid[4][1],gPanel.tSize,gPanel.tSize);
        }
    }

}