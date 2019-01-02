package com.labyrinth.yugioh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel implements MouseListener {
    // Celui ci servira a afficher toutes les infos utiles pour le joueur (description créatures, créatures restantes,etc.)
    //InfoPanel infoPanelContainer = new InfoPanel();
    // tSize correspond à la taille de nos tiles
    int tSize = 60;

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0,0,920,720);
//        infoPanelContainer.setPreferredSize(new Dimension(360,720));
//        this.add(infoPanelContainer);
//        System.out.println(infoPanelContainer);
        this.addMouseListener(this);
        // Une fois nos 2 conteneurs créés on génère le labyrinthe
        generateLabyrinth(g);
    }

    // Cette méthode va générer le labyrinthe
    public void generateLabyrinth(Graphics g){
        // Pour illustration j'ajoute le plateau de jeu de base
        //JLabel lab = new JLabel(new ImageIcon("assets/interface/img/labyrinth.png"));
        //gamePanelContainer.add(lab);
        int grid[][] = {
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0}
        };

        // Les futures tiles feront 60 sur 60 en taille
        // Le plateau fait 14 de long sur 11 de haut
        // Cette boucle va s'occuper de la hauteur
        for (int i=0;i<grid.length;i++) {
            // Et celle ci de la longueur
            // grid[i] permets de changer de ligne dans un tableau 2D (en gros ça fait grid[de 0 à 10 lignes][et de 0 à 13 colonnes])
            for (int j=0;j<grid[i].length;j++) {
                g.setColor(Color.ORANGE);
                g.drawRect(j * tSize, i * tSize, tSize, tSize);
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getSource().getClass());
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
