package com.labyrinth.yugioh;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Unit implements MouseListener {

    int posX;
    int posY;
    int w = 30;
    int h = 30;

    public Unit(int x, int y){
        // On enregistre la position de notre unité
        posX = x;
        posY = y;
    }

    // retourne la position X
    public int getX() {
        return posX;
    }

    // retourne la position Y
    public int getY() {
        return posY;
    }

    // retourne la largeur
    public int getW() {
        return w;
    }

    // retourne la hauteur
    public int getH() {
        return h;
    }

    // Permets de changer la position de notre unité en écrasant les valeurs par les nouvelles
    public void move(int newX, int newY){
        posX = newX;
        posY = newY;
    }

    public void mouseClicked(MouseEvent e) {

        System.out.println("position souris : x :"+ e.getX() + " y :" + e.getY());
        // Ces 2 valeurs permettent d'obtenir les positions x et y en ajoutant la largeur et hauteur de notre pion
        int testX = posX + w;
        int testY = posY + h;
        System.out.println("position pion + w ou h : x :"+ testX + " y: " + testY);
        // Si le bouton cliqué est celui de gauche
        if (e.getButton() == 1) {
            // On test si le clic est dans la zone de notre pion en tenant compte de x et y ainsi que x + largeur et y + hauteur
            if (((e.getX() >= posX) && (e.getX() <= testX)) && ((e.getY() >= posY) && (e.getY() <= testY))) {
                // System.out.println(posX + " " + posY);
                System.out.println("~~~~ CLIC ~~~~");
            }
        }
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
