package com.labyrinth.yugioh;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
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


        // getWidth() et getHeight() retournent la width et height de la fenêtre en divisant par 2 on centre notre contenu
        g.drawString("Hello world !",this.getWidth()/2,this.getHeight()/2);
    }


}
