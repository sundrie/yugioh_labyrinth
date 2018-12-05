package com.labyrinth.yugioh;
// On importe la librairie pour faire des fenêtres
import javax.swing.JFrame;


public class Window extends JFrame {
    int width = 1280;
    int height = 720;
    String title = "Yu-Gi-Oh! Labyrinth";
    // La méthode pour créer notre fenêtre
    public void createWindow(){
        JFrame myWindow = new JFrame();

        myWindow.setTitle(title);
        myWindow.setSize(width, height);
        // Centre la fenêtre
        myWindow.setLocationRelativeTo(null);
        // Termine le processus lorsqu'on clique sur la croix rouge
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myWindow.setVisible(true);
    }
}
