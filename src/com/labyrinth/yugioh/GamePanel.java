package com.labyrinth.yugioh;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    // Ce JPanel sera notre écran de jeu principal qui contiendra le plateau de jeu
    JPanel gamePanelContainer = new JPanel();

    public void paintComponent(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(920,0,360,720);
        g.setColor(Color.white);
        g.drawString("Et là toutes les datas utiles au jeu",1000,720/2);

        gamePanelContainer.setBackground(Color.black);
        gamePanelContainer.setSize(920,720);
        this.add(gamePanelContainer);
        System.out.println(this);
    }

}
