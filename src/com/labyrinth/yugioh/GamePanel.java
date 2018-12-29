package com.labyrinth.yugioh;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel implements MouseListener {
    JPanel mainPanel = this;
    // Celui ci servira a afficher toutes les infos utiles pour le joueur (description créatures, créatures restantes,etc.)
    InfoPanel infoPanelContainer = new InfoPanel();

    public void paintComponent(Graphics g){

        g.setColor(Color.black);
        g.fillRect(0,0,920,720);
        this.add(infoPanelContainer);
        this.addMouseListener(this);

        // Une fois nos 2 conteneurs créés on génère le labyrinthe
        generateLabyrinth(g);
    }

    // Cette méthode va générer le labyrinthe
    public void generateLabyrinth(Graphics g){
        // Pour illustration j'ajoute le plateau de jeu de base
        //JLabel lab = new JLabel(new ImageIcon("assets/interface/img/labyrinth.png"));
        //gamePanelContainer.add(lab);
        g.setColor(Color.white);
        g.drawString("generation en cours",20,20);
        // Les futures tiles feront 60 sur 60 en taille
        for (int j=0;j<14;j++){
            // System.out.println(j);
            g.setColor(Color.ORANGE);
            g.drawRect(j*60,0,60,60);

        }
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println("Clic");
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
