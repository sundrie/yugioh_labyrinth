package com.labyrinth.yugioh;

import javax.swing.JPanel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ContentPanel extends JPanel {
    // Cette méthode est fournie de base par jpanel grâce à extends JPanel on peut y accéder
    public void paintComponent(Graphics g){
        try {
            // On créé notre variable de type Image
            Image bgImgStartMenu = ImageIO.read(new File("assets/interface/img/yu-gi-oh_logo.jpg"));
            // On la dessine il faudrait ajouter après le x et y la largeur et hauteur du panel par exemple pour en faire une image de fond
            g.drawImage(bgImgStartMenu, 0, 0, this);
        } catch (IOException e) {
            System.out.println("Erreur pour l'affichage du logo");
        }

        g.drawString("made by Alexandre Blin",this.getWidth()-130,this.getHeight()-10);
    }

    // Méthode pour dessiner notre panneau de boutons
    public void drawButtons(Window theWindow){
        // On définit un nouveau panel qui contiendra nos boutons
        JPanel btncontainer = new JPanel();
        //On positionne maintenant nos boutons en utilisant GridLayout avec 2 lignes et 1 seule colonne
        btncontainer.setLayout(new GridLayout(2, 1));
        // Ceci permets aux boutons de faire leurs tailles complètes et de ne pas être ultra réduits (- de 50 px de large et 10 de haut)
        btncontainer.setPreferredSize(new Dimension(200,200));

        // Le panel est envoyé pour pouvoir le masquer lors du clic sur le bouton commencer
        btncontainer.add(new BtnStartingW("Commencer",this,theWindow));
        btncontainer.add(new BtnStartingW("Quitter",this,theWindow));

        // On ajoute notre panel de boutons à celui global
        this.add(btncontainer);
    }

}
