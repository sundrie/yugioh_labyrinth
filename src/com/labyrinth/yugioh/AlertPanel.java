package com.labyrinth.yugioh;

import java.awt.*;
import javax.swing.*;

public class AlertPanel extends JPanel {

    int w = 100;
    int h = 100;

    // Ce panel permettra de prévenir l'utilisateur avec un message
    public AlertPanel(){
        setPreferredSize(new Dimension(w,h));
    }

    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillRect(0,0,100,100);
    }
}
