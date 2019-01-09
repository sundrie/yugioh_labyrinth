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
        System.out.println(x+" "+y);
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

    public void mouseClicked(MouseEvent e) {
        System.out.println("Clic sur une unité de la team bleu");
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
