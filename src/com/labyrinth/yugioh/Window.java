package com.labyrinth.yugioh;
// On importe la librairie pour faire des fenêtres
import javax.swing.*;

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


        JPanel b1 = new JPanel();
        //On définit le layout en lui indiquant qu'il travaillera en ligne
        b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
        b1.add(new BtnStartingW("Commencer"));

        JPanel b2 = new JPanel();
        //On définit le layout en lui indiquant qu'il travaillera en ligne
        b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
        b2.add(new BtnStartingW("Quitter"));

        //On positionne maintenant nos boutons en colonne
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
//        panel.add(new BtnStartingW("Commencer"));
//        panel.add(new BtnStartingW("Quitter"));
        panel.add(b1);
        panel.add(b2);

        this.setVisible(true);
    }


}
