package com.labyrinth.yugioh;


public class GameMaster {
    // Cette classe va s'occuper de gérer tous les mécanismes, calculs permettant au jeu de fonctionner

    GamePanel gPan;
    InfoPanel iPan;
    Unit[] unitList;
    // theUnit correspond à l'unité
    Unit theUnit;
    GuideUnit theGuide;
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
    public GuideUnit drawAttackRange(Unit unit){

        theUnit = unit;
//        System.out.println("L'unité a guider "+unit.name);
//        System.out.println(unit.getX());
//        System.out.println(unit.getY());
        int[][] gridGuide ={{unit.getX()},{unit.getY()}};
        // on créé un nouveau guide auquel on envoie l'unité qui a besoin d'un guide et les positions où il doit dessiner les rectangles symbolisant la portée d'attaque
        theGuide = new GuideUnit(theUnit, gridGuide);
        return theGuide;
    }
}
