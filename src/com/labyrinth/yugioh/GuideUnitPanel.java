package com.labyrinth.yugioh;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GuideUnitPanel extends JPanel {
    GamePanel gPanel;
    ArrayList<int[]> guideGrid = new ArrayList<int[]>();
    int w;
    int h;

    public GuideUnitPanel(GamePanel gamePanel, int width, int height){
        gPanel = gamePanel;
        w = width;
        h = height;

        // Permets de mettre le JPanel en transparent
        setOpaque(false);
        // Par défaut il y a un margin à 5. On écrase ce 5 par 0 ainsi il n'y a plus de margins gênants
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
    }


    public void setGrid(ArrayList<int[]> grid){
        guideGrid = grid;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

    // On ajoute un JPanel qui peindra sur demande les tiles de guide
    public void paintTiles(){
        // On créé une nouvelle classe cette fois interne à GuideUnitPanel
        GuideUnitPanel.GuideTiles guideTiles = this.new GuideTiles();
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
            // Les cases de mouvements
            g.setColor(new Color(0,130,255, 80));

            // On peint le nombre de fois demandé de tiles
            for (int i=0;i<guideGrid.size();i++){
                // [0] est le Y et [1] le X
//                guideGrid.get(i)[0]+" "+guideGrid.get(i)[1]
                g.fillRect(guideGrid.get(i)[1]*gPanel.tSize,guideGrid.get(i)[0]*gPanel.tSize,gPanel.tSize,gPanel.tSize);
            }

//            // Pour avoir un rouge transparent
//            g.setColor(new Color(255,0,0, 80));
//            // Peint le rectangle du haut
//            g.fillRect(guideGrid[1][0],guideGrid[1][1],gPanel.tSize,gPanel.tSize);
//            // Peint le rectangle de droite
//            g.fillRect(guideGrid[2][0],guideGrid[2][1],gPanel.tSize,gPanel.tSize);
//            // Peint le rectangle du bas
//            g.fillRect(guideGrid[3][0],guideGrid[3][1],gPanel.tSize,gPanel.tSize);
//            // Peint le rectangle de gauche
//            g.fillRect(guideGrid[4][0],guideGrid[4][1],gPanel.tSize,gPanel.tSize);
//
//
//
//
//            g.fillRect(guideGrid[5][0],guideGrid[5][1],gPanel.tSize,gPanel.tSize);
        }
    }

}