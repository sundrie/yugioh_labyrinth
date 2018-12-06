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
        // getWidth() et getHeight() retournent la width et height de la fenêtre en divisant par 2 on centre notre contenu
        g.drawString("Hello world !",this.getWidth()/2,this.getHeight()/2);
    }


}
