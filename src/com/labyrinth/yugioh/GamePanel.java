package com.labyrinth.yugioh;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    JPanel mainPanel = this;
    // Ce JPanel sera notre écran de jeu principal qui contiendra le plateau de jeu
    JPanel gamePanelContainer = new JPanel();
    // Celui ci servira a afficher toutes les infos utiles pour le joueur (description créatures, créatures restantes,etc.)
    JPanel infoPanelContainer = new JPanel();

//    public void paintComponent(Graphics g){
//        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.LINE_AXIS));
//        mainPanel.setSize(1280,720);
//        gamePanelContainer.setBackground(Color.black);
//        gamePanelContainer.setSize(920,720);
//        infoPanelContainer.setBackground(Color.cyan);
//        infoPanelContainer.setPreferredSize(new Dimension(360,720));
//
//        mainPanel.add(gamePanelContainer);
//        mainPanel.add(infoPanelContainer);
//    }

    public void drawGamePanel(){
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.LINE_AXIS));
        mainPanel.setSize(1280,720);
        gamePanelContainer.setBackground(Color.black);
        // Pour illustration j'ajoute le plateau de jeu de base
        JLabel lab = new JLabel(new ImageIcon("assets/interface/img/labyrinth.png"));
        gamePanelContainer.add(lab);
        gamePanelContainer.setSize(920,720);
        infoPanelContainer.setBackground(Color.cyan);
        infoPanelContainer.setPreferredSize(new Dimension(360,720));

        mainPanel.add(gamePanelContainer);
        mainPanel.add(infoPanelContainer);
    }


}
