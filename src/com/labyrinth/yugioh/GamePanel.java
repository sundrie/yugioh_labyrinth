package com.labyrinth.yugioh;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GamePanel extends JPanel {
    JPanel mainPanel = this;
    // Ce JPanel sera notre écran de jeu principal qui contiendra le plateau de jeu
    JPanel gamePanelContainer = new JPanel();
    // Celui ci servira a afficher toutes les infos utiles pour le joueur (description créatures, créatures restantes,etc.)
    InfoPanel infoPanelContainer = new InfoPanel();

    public void drawGamePanel(){
        //mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.LINE_AXIS));
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setSize(1280,720);
        gamePanelContainer.setBackground(Color.black);
        // Pour illustration j'ajoute le plateau de jeu de base
        JLabel lab = new JLabel(new ImageIcon("assets/interface/img/labyrinth.png"));
        gamePanelContainer.add(lab);
        gamePanelContainer.setPreferredSize(new Dimension(920,720));

        mainPanel.add(gamePanelContainer, BorderLayout.WEST);
        mainPanel.add(infoPanelContainer);
    }


}
