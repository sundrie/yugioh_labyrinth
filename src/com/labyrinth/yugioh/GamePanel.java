package com.labyrinth.yugioh;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(0,0,1280,720);
        g.drawString("Game Panel Launched !",600,300);
    }
}
