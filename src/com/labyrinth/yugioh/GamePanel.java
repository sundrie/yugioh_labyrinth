package com.labyrinth.yugioh;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel implements MouseListener {
    JPanel mainPanel = this;
    // Ce JPanel sera notre écran de jeu principal qui contiendra le plateau de jeu
    JPanel gamePanelContainer = new JPanel();
    // Celui ci servira a afficher toutes les infos utiles pour le joueur (description créatures, créatures restantes,etc.)
    InfoPanel infoPanelContainer = new InfoPanel();

    public void drawGamePanel(){
        //mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.LINE_AXIS));
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setSize(1280,720);

        gamePanelContainer.setPreferredSize(new Dimension(920,720));

        mainPanel.add(gamePanelContainer, BorderLayout.WEST);
        mainPanel.add(infoPanelContainer);

        gamePanelContainer.addMouseListener(this);
        infoPanelContainer.addMouseListener(this);

        // Une fois nos 2 conteneurs créés on génère le labyrinthe
        generateLabyrinth();
    }

    // Cette méthode va générer le labyrinthe
    public void generateLabyrinth(){
        gamePanelContainer.setBackground(Color.black);
        // Pour illustration j'ajoute le plateau de jeu de base
        JLabel lab = new JLabel(new ImageIcon("assets/interface/img/labyrinth.png"));
        gamePanelContainer.add(lab);

        // Les futures tiles feront 60 sur 60 en taille
    }

    // Ceci est une classe interne
    class InfoPanel extends JPanel {

        String testString = "Informations";

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.gray);
            setPreferredSize(new Dimension(360, 720));

            // Pour les tests
            g.setColor(Color.black);
            g.drawString(testString, 20, 20);
        }
    }
    // Ceci sert d'exemple test
    int i = 0;
    public void mouseClicked(MouseEvent e) {
        i++;
        infoPanelContainer.testString = "Clic "+i+" fois !!";
        // repaint actualise le contenu
        repaint();

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
