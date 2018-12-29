package com.labyrinth.yugioh;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.cyan);
        setPreferredSize(new Dimension(360,720));
    }
}
