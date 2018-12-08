package com.labyrinth.yugioh;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class BtnStartingW extends JButton implements MouseListener {
    private String name;
    public BtnStartingW(String str){
        this.name = str;
        // Pour que l'objet s'écoute
        this.addMouseListener(this);
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

    //Méthode appelée lors du clic de souris
    public void mouseClicked(MouseEvent event) {
        System.out.println("Tu as cliqué sur le bouton"+this.name);
    }

    //Méthode appelée lors du survol de la souris
    public void mouseEntered(MouseEvent event) {
        // Ceci fait passer le curseur de la souris en main (signifie que c'est cliquable)
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    //Méthode appelée lorsque la souris sort de la zone du bouton
    public void mouseExited(MouseEvent event) { }

    //Méthode appelée lorsque l'on presse le bouton gauche de la souris
    public void mousePressed(MouseEvent event) { }


    //Méthode appelée lorsque l'on relâche le clic de souris
    public void mouseReleased(MouseEvent event) { }

}