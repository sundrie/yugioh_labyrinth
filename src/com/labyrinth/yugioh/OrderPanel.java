package com.labyrinth.yugioh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OrderPanel extends JPanel implements MouseListener {

    int w;
    int h;

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.CYAN);
    }

    public OrderPanel (int width,int height) {
        // On récupère les valeurs initialisés dans GamePanel au moment de la création de OrderPanel
        w = width;
        h = height;
        JButton wait = new JButton("Attendre");
        wait.setPreferredSize(new Dimension(w,h/2));
        add(wait);
        wait.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Ceci trouvé ici https://stackoverflow.com/questions/21287661/java-getname-of-obj-that-activated-mouselistener
        // sourcename renvoie le texte entré dans un JButton puisque source récuàère les événements des JButton uniquement
        JButton source = (JButton) e.getSource();
        String sourcename = source.getText();
        System.out.println(sourcename);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
