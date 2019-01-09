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
    int gpW = 920;
    int gpH = 720;

    Unit blueUnit;
    Unit toto = new Unit(0,0);

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0,0,gpW,gpH);
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
                {1,8,8,10,4,1,4,1,4,1,8,8,8,4},
                {2,7,5,10,0,7,5,7,9,5,3,5,0,3},
                {11,5,6,4,5,3,5,7,2,3,1,3,9,11},
                {11,2,4,5,0,10,3,2,4,1,7,1,3,11},
                {11,8,3,2,0,8,4,1,7,9,5,3,1,11},
                {11,5,10,4,9,5,0,0,7,9,2,10,7,11},
                {11,3,1,7,9,5,3,2,6,0,4,1,6,11},
                {11,1,3,5,3,2,4,1,10,0,7,2,4,11},
                {11,9,1,3,1,4,5,7,1,7,2,8,7,11},
                {1,0,7,1,7,9,5,7,5,0,10,7,5,4},
                {2,6,6,6,3,2,3,2,3,2,10,6,6,3}
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
                    case 6:
                        drawTile(g,j,i,6);
                        break;
                    case 7:
                        drawTile(g,j,i,7);
                        break;
                    case 8:
                        drawTile(g,j,i,8);
                        break;
                    case 9:
                        drawTile(g,j,i,9);
                        break;
                    case 10:
                        drawTile(g,j,i,10);
                        break;
                    case 11:
                        drawTile(g,j,i,11);
                        break;
                }
            }
        }

        generateUnits(grid,g);
    }

    // Ajoute les unités sur le labyrinthe
    // Pour l'instant et pour les tests ce sera 7 pions sur chaque spawn
    public void generateUnits(int grid[][],Graphics g){
        // Même valeur pour notre taille et width qui seront identiques on stocke dans cette variable par simplicité
        int unitSize = 30;
        // Puisque les points de spawn sur ce labyrinth sont fixés il suffit d'une seule boucle pour la colonne 0 et 13
        for (int i=0;i<grid.length;i++){
            // Les tiles 11 correspondent à nos points de spawn
            if (grid[i][0]==11){
                Unit blueUnit = new Unit(unitSize/2,i*tSize+unitSize/2);
                g.setColor(Color.blue);
                g.fillOval(blueUnit.getX(),blueUnit.getY(),blueUnit.getW(),blueUnit.getH());
            }

            if (grid[i][13]==11){
                Unit redUnit = new Unit(gpW-tSize*2,i*tSize+unitSize/2);
                g.setColor(Color.red);
                g.fillOval(redUnit.getX(),redUnit.getY(),redUnit.getW(),redUnit.getH());
            }
        }
        g.setColor(Color.magenta);
        g.fillOval(toto.getX(),toto.getY(),toto.getW(),toto.getH());
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
//        System.out.println(e.getSource().getClass());
        // e.getX() renvoie la position où à eu lieu l'événement (ici un clic)
        toto.move(e.getX(), e.getY());
        repaint(toto.getX(),toto.getY(),toto.getW(),toto.getH());
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
