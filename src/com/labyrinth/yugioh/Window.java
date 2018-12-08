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

        JPanel pbtn1 = new JPanel();
        //On définit le layout en lui indiquant qu'il travaillera en ligne
        pbtn1.setLayout(new BoxLayout(pbtn1, BoxLayout.LINE_AXIS));
        pbtn1.add(new BtnStartingW("Commencer"));
        System.out.println(pbtn1.getPreferredSize());

        JPanel pbtn2 = new JPanel();
        pbtn2.setLayout(new BoxLayout(pbtn2, BoxLayout.LINE_AXIS));
        pbtn2.add(new BtnStartingW("Quitter"));


        JPanel btncontainer = new JPanel();
        //On positionne maintenant nos boutons en colonne
        // container.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        btncontainer.setLayout(new GridLayout(2, 1));
        btncontainer.setPreferredSize(new Dimension(200,600));
        btncontainer.add(pbtn1);
        btncontainer.add(pbtn2);
        panel.add(btncontainer);
        this.setVisible(true);
    }


}
