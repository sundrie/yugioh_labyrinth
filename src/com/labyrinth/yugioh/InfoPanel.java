package com.labyrinth.yugioh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// Ceci est une classe interne
class InfoPanel extends JPanel implements MouseListener {

    String testString = "Informations";

    public void paintComponent(Graphics g) {
        System.out.println("ENCULAR !");
        //super.paintComponent(g);
        setBackground(Color.gray);
        setPreferredSize(new Dimension(360, 720));

        // Pour les tests
        g.setColor(Color.black);
        g.drawString(testString, 20, 20);


    }

    // Ceci sert d'exemple test
    int i = 0;
    public void mouseClicked(MouseEvent e) {
        i++;
        this.testString = "Clic "+i+" fois !!";
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