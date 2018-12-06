package com.labyrinth.yugioh;

import java.awt.*;
import javax.swing.JButton;

public class BtnStartingW extends JButton {
    private String name;
    public BtnStartingW(String str){
        this.name = str;
    }
    public void paintComponent(Graphics g){
        // On définit la taille de nos boutons
        this.setSize(200,100);
        // Ceci est pour changer la couleur de fond du bouton
        g.setColor(Color.gray);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        // Ceci est pour changer la couleur du texte
        g.setColor(Color.white);

        // Ce bout de code sert a centrer le texte (trouvé sur : https://stackoverflow.com/questions/32859509/how-to-center-a-drawstring-in-java)
        Graphics2D g2d = (Graphics2D)g.create();
        FontMetrics fm = g2d.getFontMetrics();
        int centeredX = (this.getWidth() - fm.stringWidth(this.name)) / 2;

        g.drawString(this.name, centeredX, this.getHeight()/2);
    }

}
