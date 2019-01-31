package com.labyrinth.yugioh;


public class GameMaster {
    // Cette classe va s'occuper de gérer tous les mécanismes, calculs permettant au jeu de fonctionner

    GamePanel gPan;
    InfoPanel iPan;
    Unit[] unitList;
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
    public int[][] drawAttackRange(Unit unit){
        System.out.println("L'unité a guider "+unit.name);
        int[][] data ={{},{}};
        return data;
    }
}
