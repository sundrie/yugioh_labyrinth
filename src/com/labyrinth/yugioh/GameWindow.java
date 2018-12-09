package com.labyrinth.yugioh;
// On importe la librairie pour faire des fenêtres
import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    int width = 1280;
    int height = 720;
    String title = "Yu-Gi-Oh! Labyrinth";
    // La méthode pour créer notre fenêtre
    public void createWindow(){
        this.setTitle(title);
        this.setSize(width, height);
        // Centre la fenêtre
        this.setLocationRelativeTo(null);
        // Ferme la fenêtre en cours lorsqu'on clique sur la croix rouge au lieu de fermer tout comme le fait JFrame.EXIT_ON_CLOSE
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        this.setVisible(true);
    }


}
