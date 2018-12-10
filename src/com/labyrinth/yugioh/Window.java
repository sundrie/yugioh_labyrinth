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

        // On définit un nouveau panel qui contiendra nos boutons
        JPanel btncontainer = new JPanel();
        //On positionne maintenant nos boutons en utilisant GridLayout avec 2 lignes et 1 seule colonne
        btncontainer.setLayout(new GridLayout(2, 1));
        // Ceci permets aux boutons de faire leurs tailles complètes et de ne pas être ultra réduits (- de 50 px de large et 10 de haut)
        btncontainer.setPreferredSize(new Dimension(200,200));

        // Le panel est envoyé pour pouvoir le masquer lors du clic sur le bouton commencer
        btncontainer.add(new BtnStartingW("Commencer",panel));
        btncontainer.add(new BtnStartingW("Quitter",panel));

        // On ajoute notre panel de boutons à celui global
        panel.add(btncontainer);

        this.setVisible(true);
    }


}
