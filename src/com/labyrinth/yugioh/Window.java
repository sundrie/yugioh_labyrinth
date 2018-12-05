package com.labyrinth.yugioh;
// On importe la librairie pour faire des fenêtres
import javax.swing.JFrame;


public class Window {
    // La méthode pour créer notre fenêtre
    public static void createWindow(){
        JFrame myWindow = new JFrame();

        myWindow.setTitle("Yu-Gi-Oh! Labyrinth");
        myWindow.setSize(1280, 720);
        // Centre la fenêtre
        myWindow.setLocationRelativeTo(null);
        // Termine le processus lorsqu'on clique sur la croix rouge
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myWindow.setVisible(true);
    }
}
