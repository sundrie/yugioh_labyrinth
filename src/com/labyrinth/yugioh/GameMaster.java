package com.labyrinth.yugioh;


import java.awt.*;

public class GameMaster {
    // Cette classe va s'occuper de gérer tous les mécanismes, calculs permettant au jeu de fonctionner

    GamePanel gPan;
    InfoPanel iPan;
    Unit[] unitList;
    // theUnit correspond à l'unité
    Unit theUnit;
    GuideUnitPanel theGuide;
    int[][] grid;

    public GameMaster(GamePanel gp, InfoPanel ip){
        gPan = gp;
        iPan = ip;
    }

    public void getUnit(Unit[] unitArray){
        unitList = unitArray;
//        System.out.println(unitList[0].name);
//        System.out.println(unitList[1].name);
    }

    public void getGrid(int[][] g){
        grid = g;
//        System.out.println(grid[0][0]);
    }

    // montre la portée d'attaque de l'unité sélectionnée pour que GamePanel puisse le dessiner
    public GuideUnitPanel drawAttackRange(Unit unit){

        theUnit = unit;
//        System.out.println("L'unité a guider "+unit.name);
//        System.out.println(unit.getX());
//        System.out.println(unit.getY());
        int[][] gridGuide ={
                {unit.getX(),unit.getY()},
                {unit.getX()+unit.w,unit.getY()-gPan.tSize} // Pour la case en haut

        };
        theGuide = new GuideUnitPanel(theUnit, gridGuide, gPan, gPan.gpW, gPan.gpH);
        // le guide sera par dessus le labyrinth on lui donne la taille de notre GamePanel
        theGuide.setPreferredSize(new Dimension(gPan.gpW, gPan.gpH));
        // On renvoie le guide que GamePanel va devoir ajouter
        return(theGuide);
    }
}
