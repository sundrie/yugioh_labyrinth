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
    // Comme son nom l'indique ça sera utilisé pour gérer les collisions (murs, limites de terrains)
    // Dans l'ordre ID et le sens des aiguilles d'une montre H,D,B,G
    int[][][] collisionGrid = {
            {{1},{8},{8},{10},{4},{1},{4},{1},{4},{1},{8},{8},{8},{4}},
            {{2},{7},{5},{10},{0},{7},{5},{7},{9},{5},{3},{5},{0},{3}},
            {{11},{5},{6},{4},{5},{3},{5},{7},{2},{3},{1},{3},{9},{11}},
            {{11},{2},{4},{5},{0},{10},{3},{2},{4},{1},{7},{1},{3},{11}},
            {{11},{8},{3},{2},{0},{8},{4},{1},{7},{9},{5},{3},{1},{11}},
            {{11},{5},{10},{4},{9},{5},{0},{0},{7},{9},{2},{10},{7},{11}},
            {{11},{3},{1},{7},{9},{5},{3},{2},{6},{0},{4},{1},{6},{11}},
            {{11},{1},{3},{5},{3},{2},{4},{1},{10},{0},{7},{2},{4},{11}},
            {{11},{9},{1},{3},{1},{4},{5},{7},{1},{7},{2},{8},{7},{11}},
            {{1},{0},{7},{1},{7},{9},{5},{7},{5},{0},{10},{7},{5},{4}},
            {{2},{6},{6},{6},{3},{2},{3},{2},{3},{2},{10},{6},{6},{3}}

    };


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

        theUnit = unit;

        int tileInfo[] = gPan.getTileInfo(unit.getX(),unit.getY());
//        System.out.println(tileInfo[0]+" "+tileInfo[1]+" "+tileInfo[2]);

        // Les résultats sont multipliés par la taille de tile afin d'obtenir les x et y de la tile où se trouve l'unité
        int unitTileX = tileInfo[0]*gPan.tSize;
        int unitTileY = tileInfo[1]*gPan.tSize;
        int tileId = tileInfo[2];
        // Ces 2 variables nous donnent les coordonnées d'où se trouve l'unité
        int tilePosX = tileInfo[0];
        int tilePosY = tileInfo[1];

        // C'est la distance max que peut parcourir l'unité
        int unitMaxMvt = theUnit.level;

        // Droite
//        System.out.println("ID de la tile la plus à droite : "+grid[tilePosY][tilePosX+unitMaxMvt]);
//        System.out.println(tilePosX+unitMaxMvt);

        int[][] gridGuide ={
                {unitTileX,unitTileY},  // Les coordonnées de la tile où se trouve l'unité
                {unitTileX,unitTileY-gPan.tSize}, // La case en haut
                {tilePosX+unitMaxMvt*gPan.tSize+gPan.tSize,unitTileY},   // La case de droite
                {unitTileX,unitTileY+gPan.tSize},    // La case du bas
                {unitTileX-gPan.tSize,unitTileY},    // La case de gauche
                {tilePosX+unitMaxMvt*gPan.tSize,unitTileY}  // La case de mouvement la plus à droite
        };

        isOOB(gridGuide);

        theGuide = guideP;

        // On envoie les coordonnées des tiles que doit peindre notre guide
        theGuide.setGrid(gridGuide);

        // On créé une nouvelle classe cette fois interne à GuideUnitPanel
        GuideUnitPanel.GuideTiles guideTiles = theGuide.new GuideTiles() ;
//        System.out.println(gridGuide[2][0]+" "+gridGuide[2][1]);
        theGuide.paintTiles(guideTiles);
    }

    // Détermine si quelque chose est OOB = Out of Bonds en dehors des limites du labyrinthe
    public void isOOB(int[][] array){
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array[i].length;j++){
                // Si la valeur est inférieure à 0 ou supérieure à la width du labyrinthe c'est donc qu'elle est OOB
                if (array[i][j]<0 || array[i][j] >= gPan.LabW){
//                    System.out.println("Valeurs OOB ! i: "+i+"/ j: "+j+" | "+array[i][j]);
                    // On écrase la valeur OOB par une nouvelle incorrecte
                    array[i][j] = 713705;
                }
//                System.out.println("i: "+i+"/ j: "+j+" | "+array[i][j]);
            }
        }
    }

}
