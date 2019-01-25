package com.labyrinth.yugioh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// Ceci est une classe interne
public class InfoPanel extends JPanel implements MouseListener {

    // Va s'occuper d'afficher nos unités encore vivantes
    JLabel alliedLeftUnit = new JLabel("Nombre d'unités alliées vivantes : 0");
    // Va s'occuper d'afficher les unités ennemies encore vivantes
    JLabel enemyLeftUnit = new JLabel("Nombre d'unités ennemies vivantes : 0");
    // Va s'occuper d'afficher le nom de l'unité sélectionnée
    JLabel unitInfo= new JLabel("");
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.gray);
        g.fillRect(920,0,360,720);
        alliedLeftUnit.setFont(new Font("Arial",Font.PLAIN,18));
        add(alliedLeftUnit);
        // Permets de capter les actions de la souris sur le label
        alliedLeftUnit.addMouseListener(this);

        enemyLeftUnit.setFont(new Font("Arial",Font.PLAIN,18));
        add(enemyLeftUnit);
        // Permets de capter les actions de la souris sur le label
        enemyLeftUnit.addMouseListener(this);

        // setForeground() défini la couleur de la police utilisée par le JLabel
        unitInfo.setForeground(Color.BLUE);
        unitInfo.setFont(new Font("Arial",Font.ITALIC,24));
        add(unitInfo);

        // Validate est obligatoire pour que les JLabel s'affiche
        validate();
    }


    // Permets d'afficher les infos envoyés par Unit via GamePanel
    public void displayUnitInfo(Unit unit,String name){
        // On écrase la valeur précédente du JLabel soit "" ou le nom de la précédente unité sélectionnée
        unitInfo.setText(name);

//        System.out.println("from InfoPanel :"+ unit);
//        System.out.println("from InfoPanel :"+ unit.getX());
//        System.out.println("from InfoPanel :"+ name);
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getSource());
    }


    public void mousePressed(MouseEvent e) {

    }


    public void mouseReleased(MouseEvent e) {

    }


    public void mouseEntered(MouseEvent e) {
    }


    public void mouseExited(MouseEvent e) {

    }
}