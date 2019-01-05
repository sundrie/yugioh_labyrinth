package com.labyrinth.yugioh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

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
                {1,0,0,0,4,1,4,1,4,1,0,0,0,4},
                {2,0,5,0,0,0,5,0,0,5,3,5,0,3},
                {11,5,0,4,5,3,5,0,2,0,1,3,0,11},
                {11,2,4,5,0,0,3,2,4,1,0,1,3,11},
                {11,0,3,2,0,0,4,1,0,0,5,3,1,11},
                {11,5,0,4,0,5,0,0,0,0,2,0,0,11},
                {11,3,1,0,0,5,3,2,0,0,4,1,0,11},
                {11,1,3,5,3,2,4,1,0,0,0,2,4,11},
                {11,0,1,3,1,4,5,0,1,0,2,0,0,11},
                {1,0,0,1,0,0,5,0,5,0,0,0,5,4},
                {2,0,0,0,3,2,3,2,3,2,0,0,0,3}
        };

        // Les futures tiles feront 60 sur 60 en taille
        // Le plateau fait 14 de long sur 11 de haut
        // Cette boucle va s'occuper de la hauteur
        for (int i=0;i<grid.length;i++) {
            // Et celle ci de la longueur
            // grid[i] permets de changer de ligne dans un tableau 2D (en gros ça fait grid[de 0 à 10 lignes][et de 0 à 13 colonnes])
            for (int j=0;j<grid[i].length;j++) {
                // Un switch sera mieux que plusieurs if (et ça permets d'utiliser quelque chose de peu utilisé)
                switch (grid[i][j]){
                    case 0:
                        drawTile(g,j,i,0);
                        break;
                    case 1:
                        drawTile(g,j,i,1);
                        break;
                    case 2:
                        drawTile(g,j,i,2);
                        break;
                    case 3:
                        drawTile(g,j,i,3);
                        break;
                    case 4:
                        drawTile(g,j,i,4);
                        break;
                    case 5:
                        drawTile(g,j,i,5);
                        break;
                    case 11:
                        drawTile(g,j,i,11);
                        break;
                }
            }
        }
    }

    // Permets de dessiner la tile demandée
    public void drawTile(Graphics g,int j,int i,int tilenb){
        try {
            // On créé notre variable de type Image puis on la dessine selon le tilenb
            Image tile = ImageIO.read(new File("assets/game/labyrinth/tiles/tile"+tilenb+".png"));
            g.drawImage(tile,j * tSize, i * tSize, this);
        } catch (IOException e) {
            System.out.println("Erreur pour l'affichage de la tile");
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
