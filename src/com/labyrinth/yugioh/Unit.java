package com.labyrinth.yugioh;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Unit implements MouseListener {
    String name;
    int posX;
    int posY;
    int w = 30;
    int h = 30;
    GamePanel pCont;

    public Unit(GamePanel gamePanel, String uName, int x, int y){
        // On enregistre aussi son nom
        name = uName;
        // On enregistre la position de notre unité
        posX = x;
        posY = y;
        // On enregistre le panel parent qui contient tout le contenu du jeu
        pCont = gamePanel;
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

    // Cette méthode est appelée par l'OrderPanel lorsqu'un clic sur le bouton Annulé a été effectué
    public void cancelMove(){
        System.out.println("Bien reçu je retourne à ma précédente position");
    }

    // Cette méthode est appelée par l'OrderPanel lorsqu'un clic sur le bouton Attendre a été effectué
    public void waitingTime(){
        System.out.println("Moi le noble "+ name + " a entendu ton souhait et va attendre sagement");
    }

    public void mouseClicked(MouseEvent e) {

//        System.out.println("position souris : x :"+ e.getX() + " y :" + e.getY());
        // Ces 2 valeurs permettent d'obtenir les positions x et y en ajoutant la largeur et hauteur de notre pion
        int testX = posX + w;
        int testY = posY + h;
//        System.out.println("position pion + w ou h : x :"+ testX + " y: " + testY);
        // Si le bouton cliqué est celui de gauche
        if (e.getButton() == 1) {
            // On test si le clic est dans la zone de notre pion en tenant compte de x et y ainsi que x + largeur et y + hauteur
            if (((e.getX() >= posX) && (e.getX() <= testX)) && ((e.getY() >= posY) && (e.getY() <= testY))) {
                System.out.println("CLIC sur "+name);
                // On envoie toutes les datas de l'unitée cliquée
                pCont.collectUnitData(this,name);
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
