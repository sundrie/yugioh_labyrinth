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
//    public GuideUnitPanel drawAttackRange(Unit unit){
//
//        theUnit = unit;
//
//        int tileInfo[] = gPan.getTileInfo(unit.getX(),unit.getY());
////        System.out.println(tileInfo[0]+" "+tileInfo[1]+" "+tileInfo[2]);
//
//        // Les résultats sont multipliés par la taille de tile afin d'obtenir les x et y de la tile où se trouve l'unité
//        int unitTileX = tileInfo[0]*gPan.tSize;
//        int unitTileY = tileInfo[1]*gPan.tSize;
//        int tileId = tileInfo[2];
//
//        int[][] gridGuide ={
//                {unitTileX,unitTileY},  // Les coordonnées de la tile où se trouve l'unité
//                {unitTileX,unitTileY-gPan.tSize}, // La case en haut
//                {unitTileX+gPan.tSize,unitTileY},   // La case de droite
//                {unitTileX,unitTileY+gPan.tSize},    // La case du bas
//                {unitTileX-gPan.tSize,unitTileY}    // La case de gauche
//        };
//        System.out.println(gridGuide[4][0]+" "+gridGuide[4][1]);
////        theGuide = new GuideUnitPanel(theUnit, gridGuide, gPan, gPan.gpW, gPan.gpH);
//        // le guide sera par dessus le labyrinth on lui donne la taille de notre GamePanel
//        theGuide.setPreferredSize(new Dimension(gPan.gpW, gPan.gpH));
//        // On renvoie le guide que GamePanel va devoir ajouter
//        return(theGuide);
//    }

    public void newGuidDraw(GuideUnitPanel guideP,Unit unit){

        int tileInfo[] = gPan.getTileInfo(unit.getX(),unit.getY());
//        System.out.println(tileInfo[0]+" "+tileInfo[1]+" "+tileInfo[2]);

        // Les résultats sont multipliés par la taille de tile afin d'obtenir les x et y de la tile où se trouve l'unité
        int unitTileX = tileInfo[0]*gPan.tSize;
        int unitTileY = tileInfo[1]*gPan.tSize;
        int tileId = tileInfo[2];

        int[][] gridGuide ={
                {unitTileX,unitTileY},  // Les coordonnées de la tile où se trouve l'unité
                {unitTileX,unitTileY-gPan.tSize}, // La case en haut
                {unitTileX+gPan.tSize,unitTileY},   // La case de droite
                {unitTileX,unitTileY+gPan.tSize},    // La case du bas
                {unitTileX-gPan.tSize,unitTileY}    // La case de gauche
        };
        theGuide = guideP;

        theGuide.setGrid(gridGuide);
        theGuide.setUnit();
        GuideUnitPanel.GuideTiles guidee = theGuide.new GuideTiles() ;
        System.out.println(gridGuide[2][0]+" "+gridGuide[2][1]);
        theGuide.test(guidee);
    }
}
