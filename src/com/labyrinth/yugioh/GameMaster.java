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
    // La première valeur [] est le Y, la seconde [] le X et enfin la troisième [] se découpe ainsi :
    // 0: ID, 1: Haut, 2: Droite, 3: Bas, 4: Gauche
    int[][][] collisionGrid = {
            {{1,0,1,1,0},{8,0,1,1,1},{8,0,1,1,1},{10,0,0,1,1},{4,0,0,1,1},{1,0,1,1,0},{4,0,0,1,1},{1,0,1,1,0},{4,0,0,1,1},{1,0,1,1,0},{8,0,1,1,1},{8,0,1,1,1},{8,0,1,1,1},{4,0,0,1,1}},
            {{2,1,1,0,0},{7,1,0,1,1},{5,1,1,1,0},{10,0,1,0,1},{0,1,1,1,1},{7,1,0,1,1},{5,1,1,1,0},{7,1,0,1,1},{9,1,0,1,0},{5,1,1,1,0},{3,1,0,0,1},{5,1,1,1,0},{0,1,1,1,1},{3,1,0,0,1}},
            {{11,0,0,1,0},{5,1,1,1,0},{6,1,1,0,1},{4,0,0,1,1},{5,1,1,1,0},{3,1,0,0,1},{5,1,1,1,0},{7,1,0,1,1},{2,1,1,0,0},{3,1,0,0,1},{1,0,1,1,0},{3,1,0,0,1},{9,1,0,1,0},{11,0,0,1,0}},
            {{11,1,0,1,0},{2,1,1,0,0},{4,0,0,1,1},{5,1,1,1,0},{0,1,1,1,1},{10,0,1,0,1},{3,1,0,0,1},{2,1,1,0,0},{4,0,0,1,1},{1,0,1,1,0},{7,1,0,1,1},{1,0,1,1,0},{3,1,0,0,1},{11,1,0,1,0}},
            {{11,1,1,1,0},{8,0,1,1,1},{3,1,0,0,1},{2,1,1,0,0},{0,1,1,1,1},{8,0,1,1,1},{4,0,0,1,1},{1,0,1,1,0},{7,1,0,1,1},{9,1,0,1,0},{5,1,1,1,0},{3,1,0,0,1},{1,0,1,1,0},{11,1,0,1,1}},
            {{11,1,0,1,0},{5,1,1,1,0},{10,0,1,0,1},{4,0,0,1,1},{9,1,0,1,0},{5,1,1,1,0},{0,1,1,1,1},{0,1,1,1,1},{7,1,0,1,1},{9,1,0,1,0},{2,1,1,0,0},{10,0,1,0,1},{7,1,0,1,1},{11,1,0,1,0}},
            {{11,1,1,1,0},{3,1,0,0,1},{1,0,1,1,0},{7,1,0,1,1},{9,1,0,1,0},{5,1,1,1,0},{3,1,0,0,1},{2,1,1,0,0},{6,1,1,0,1},{0,1,1,1,1},{4,0,0,1,1},{1,0,1,1,0},{6,1,1,0,1},{11,1,0,1,1}},
            {{11,1,0,1,0},{1,0,1,1,0},{3,1,0,0,1},{5,1,1,1,0},{3,1,0,0,1},{2,1,1,0,0},{4,0,0,1,1},{1,0,1,1,0},{10,0,1,0,1},{0,1,1,1,1},{7,1,0,1,1},{2,1,1,0,0},{4,0,0,1,1},{11,1,0,1,0}},
            {{11,1,0,0,0},{9,1,0,1,0},{1,0,1,1,0},{3,1,0,0,1},{1,0,1,1,0},{4,0,0,1,1},{5,1,1,1,0},{7,1,0,1,1},{1,0,1,1,0},{7,1,0,1,1},{2,1,1,0,0},{8,0,1,1,1},{7,1,0,1,1},{11,1,0,0,0}},
            {{1,0,1,1,0},{0,1,1,1,1},{7,1,0,1,1},{1,0,1,1,0},{7,1,0,1,1},{9,1,0,1,0},{5,1,1,1,0},{7,1,0,1,1},{5,1,1,1,0},{0,1,1,1,1},{10,0,1,0,1},{7,1,0,1,1},{5,1,1,1,0},{4,0,0,1,1}},
            {{2,1,1,0,0},{6,1,1,0,1},{6,1,1,0,1},{6,1,1,0,1},{3,1,0,0,1},{2,1,1,0,0},{3,1,0,0,1},{2,1,1,0,0},{3,1,0,0,1},{2,1,1,0,0},{10,0,1,0,1},{6,1,1,0,1},{6,1,1,0,1},{3,1,0,0,1}}
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

        //  Pas OK
//        for (int i=tilePosY;i<=unitMaxMvt;i++) {
//            for (int j=tilePosX; j <=unitMaxMvt; j++) {
//                for (int k=0; k <=unitMaxMvt; k++){
//                    System.out.println("i : "+i+" j: "+j+" ID: "+collisionGrid[i][j][0]);
//                }
//            }
//        }

        // On parcourt les collisions pour savoir si i dans une direction c'est bloqué ou non
        for (int i=1;i<collisionGrid[tilePosY][tilePosX].length;i++) {
            System.out.println(collisionGrid[tilePosY][tilePosX][i]);



            // Si le bas est bloqué
            if (i == 3 && collisionGrid[tilePosY][tilePosX][i] == 0){
                System.out.println("La case situé en : "+(tilePosY+1)+" - "+tilePosX+" est inaccesible");
            } else if (i == 3 && collisionGrid[tilePosY][tilePosX][i] == 1){
                System.out.println("La case situé en : "+(tilePosY+1)+" - "+tilePosX+" est accesible");
            }
        }




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
