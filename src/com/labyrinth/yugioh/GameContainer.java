package com.labyrinth.yugioh;

import javax.swing.*;
import java.awt.*;

public class GameContainer extends JPanel {

    public void launch(){
        this.setBackground(Color.gray);
        this.setLayout(new BorderLayout());
        GamePanel gameScreen = new GamePanel();
        gameScreen.setPreferredSize(new Dimension(920,720));
        add(gameScreen,BorderLayout.WEST);

        InfoPanel infoContainer = new InfoPanel();
        infoContainer.setPreferredSize(new Dimension(360,720));
        add(infoContainer);

        gameScreen.getInfoPanel(infoContainer);

        GameMaster gm = new GameMaster(gameScreen, infoContainer);
        gameScreen.getGameMaster(gm);
        infoContainer.getGameMaster(gm);
    }
}
