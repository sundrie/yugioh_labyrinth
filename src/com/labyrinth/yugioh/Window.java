package com.labyrinth.yugioh;
// On importe la librairie pour faire des fenêtres
import javax.swing.*;

public class Window extends JFrame {
    int width = 1280;
    int height = 720;
    String title = "Yu-Gi-Oh! Labyrinth";
    // La méthode pour créer notre fenêtre
    public void createWindow(){

        // on dit à Window que notre classe ContentPanel est son contentPane
        this.setContentPane(new ContentPanel());

        this.setTitle(title);
        this.setSize(width, height);
        // Centre la fenêtre
        this.setLocationRelativeTo(null);
        // Termine le processus lorsqu'on clique sur la croix rouge
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // JButton startButton = new JButton("Commencer");
        this.add(new BtnStartingW("Commencer"));

        this.add(new BtnStartingW("Quitter"));



        this.setVisible(true);
    }


}
