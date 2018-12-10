package com.labyrinth.yugioh;
// On importe la librairie pour faire des fenêtres
import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    int width = 1280;
    int height = 720;
    String title = "Yu-Gi-Oh! Labyrinth";
    private ContentPanel panel = new ContentPanel();
    // La méthode pour créer notre fenêtre
    public void createWindow(){
        // on dit à Window que notre classe ContentPanel est son contentPane
        this.setContentPane(panel);
        this.setTitle(title);
        this.setSize(width, height);
        // Centre la fenêtre
        this.setLocationRelativeTo(null);
        // Termine le processus lorsqu'on clique sur la croix rouge
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Pour empêcher la multiplication de nos boutons (à cause de add())
        boolean alreadyExecuted = false;
        if(!alreadyExecuted) {
            panel.drawButtons();
            alreadyExecuted = true;
        }


        this.setVisible(true);
    }


}
