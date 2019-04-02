package com.labyrinth.yugioh;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Unit implements MouseListener {

    // Les caractérisrtiques des unités
    String name;
    int level;
    int atk;
    int def;

    // Tout ce qui concerne la position de l'unité
    int posX;
    int posY;
    int prevposX;
    int prevposY;
    int w = 30;
    int h = 30;

    GamePanel pCont;
    OrderPanel ordP;
    GameMaster gm;
    // Ce booléen indiquera si l'unité a agit ou non
    // Il est initialisé a vrai car à sa création une unité ne peut avoir agit avant
    boolean canAct = true;

    public Unit(GameMaster gMaster, GamePanel gamePanel, OrderPanel op, int x, int y, String uName, int lvl, int attaque, int defense){
        // On enregistre aussi son nom
        name = uName;
        level = lvl;
        atk = attaque;
        def = defense;

        // On enregistre la position de notre unité
        posX = x;
        posY = y;
        // On enregistre le panel parent qui contient tout le contenu du jeu
        pCont = gamePanel;
        ordP = op;

        gm = gMaster;
//        System.out.println(name+level+atk+def);
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
        // Avant d'écraser les valeurs de posX et posY elles seront conservées dans d'autres variables pour permettre d'annuler son mouvement
        prevposX = posX;
        prevposY = posY;

        posX = newX;
        posY = newY;

//        System.out.println("previous pos : "+prevposX +" "+ prevposY);
//        System.out.println("nouvelle pos : "+posX+" "+posY);
    }

    // Cette méthode est appelée par l'OrderPanel lorsqu'un clic sur le bouton Annulé a été effectué
    public void cancelMove(){
        pCont.moveAndPaintUnit(prevposX,prevposY);
    }

    // Cette méthode est appelée par l'OrderPanel lorsqu'un clic sur le bouton Attendre a été effectué
    public void waitingTime(){
        ordP.conceal();
        // On passe la possibilité de l'unité a agir a faux car elle attends jusqu'a la fin du tour
        canAct = false;
    }

    public void mouseClicked(MouseEvent e) {
//        System.out.println("position souris : x :"+ e.getX() + " y :" + e.getY());
        // Ces 2 valeurs permettent d'obtenir les positions x et y en ajoutant la largeur et hauteur de notre pion
        int testX = posX + w;
        int testY = posY + h;
//        System.out.println("position pion + w ou h : x :"+ testX + " y: " + testY);
        // Si le bouton cliqué est celui de gauche
        if (e.getButton() == 1){
            // On test si le clic est dans la zone de notre pion en tenant compte de x et y ainsi que x + largeur et y + hauteur
            if (((e.getX() >= posX) && (e.getX() <= testX)) && ((e.getY() >= posY) && (e.getY() <= testY))) {
                gm.unitClicked(this);
                // On envoie toutes les datas de l'unitée cliquée
                pCont.collectUnitData(this);
                pCont.drawGuide(this);


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
