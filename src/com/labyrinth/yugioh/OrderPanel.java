package com.labyrinth.yugioh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OrderPanel extends JPanel implements MouseListener {

    int w;
    int h;
    Unit myUnit;

    @Override
    public void paintComponent(Graphics g){
        // Par défaut il y a un margin à 5. On écrase ce 5 par 0 ainsi il n'y a plus de margins gênants
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        super.paintComponent(g);
        setBackground(Color.CYAN);
    }

    public OrderPanel (int width,int height,Unit unit) {
        // On récupère les valeurs initialisés dans GamePanel au moment de la création de OrderPanel
        w = width;
        h = height;
        // myUnit ici correspond à l'unité auquel est liée l'OrderPanel
        myUnit = unit;

        JButton wait = new JButton("Attendre");
        wait.setPreferredSize(new Dimension(w,h/2));
        add(wait);
        wait.addMouseListener(this);

        JButton cancel = new JButton("Annuler");
        cancel.setPreferredSize(new Dimension(w,h/2));
        add(cancel);
        cancel.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Ceci trouvé ici https://stackoverflow.com/questions/21287661/java-getname-of-obj-that-activated-mouselistener
        // sourcename renvoie le texte entré dans un JButton puisque source récuàère les événements des JButton uniquement
        JButton source = (JButton) e.getSource();
        String sourcename = source.getText();
        System.out.println(sourcename);

        if (sourcename == "Attendre"){
//            System.out.println(myUnit.name+" va attendre");
            myUnit.waitingTime();
        }
        if (sourcename == "Annuler"){
//            System.out.println(myUnit.name+" annule ton mouvement !");
            myUnit.cancelMove();
        }
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
