package com.labyrinth.yugioh;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0,0,920,720);
        g.setColor(Color.white);
        g.drawString("Là où sera le jeu",920/2,720/2);
        g.setColor(Color.gray);
        g.fillRect(920,0,360,720);
        g.setColor(Color.white);
        g.drawString("Et là toutes les datas utiles au jeu",1000,720/2);
    }
}
