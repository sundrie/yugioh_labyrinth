package com.labyrinth.yugioh;


import java.lang.reflect.Array;
import java.util.*;

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

    String gridS[][] = {
            {"A0","B0","C0","D0","E0","F0","G0","H0","I0","J0","K0","L0","M0","N0"},
            {"A1","B1","C1","D1","E1","F1","G1","H1","I1","J1","K1","L1","M1","N1"},
            {"A2","B2","C2","D2","E2","F2","G2","H2","I2","J2","K2","L2","M2","N2"},
            {"A3","B3","C3","D3","E3","F3","G3","H3","I3","J3","K3","L3","M3","N3"},
            {"A4","B4","C4","D4","E4","F4","G4","H4","I4","J4","K4","L4","M4","N4"},
            {"A5","B5","C5","D5","E5","F5","G5","H5","I5","J5","K5","L5","M5","N5"},
            {"A6","B6","C6","D6","E6","F6","G6","H6","I6","J6","K6","L6","M6","N6"},
            {"A7","B7","C7","D7","E7","F7","G7","H7","I7","J7","K7","L7","M7","N7"},
            {"A8","B8","C8","D8","E8","F8","G8","H8","I8","J8","K8","L8","M8","N8"},
            {"A9","B9","C9","D9","E9","F9","G9","H9","I9","J9","K9","L9","M9","N9"},
            {"A10","B10","C10","D10","E10","F10","G10","H10","I10","J10","K10","L10","M10","N10"}
    };


    // ArrayList permets de push dans un Array car les array de base en java ont une taille fixe
    // On précise que ArrayList contiendra des arrays d'entiers
    ArrayList<int[]> guideMvt = new ArrayList<int[]>();
    // tmp comme son nom l'indique servira pour add() car mettre add({tilePosY - 1, tilePosX}) ne fonctionne pas
    int[] tmp ={};


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

        // On créé une nouvelle classe cette fois interne à GuideUnitPanel
        GuideUnitPanel.GuideTiles guideTiles = theGuide.new GuideTiles() ;
//        System.out.println(gridGuide[2][0]+" "+gridGuide[2][1]);
        theGuide.paintTiles(guideTiles);


        int[] uPos = {tilePosY,tilePosX};

        // Grâce aux 2 valeurs de tilePosY et tilePosX ont récupère la position de l'unité dans notre gridS
        String unitPosString = gridS[tilePosY][tilePosX];
//        System.out.println(unitPosString);

        // Ce set va stocker nos positions sans doublons grâce aux propriétés des Set
        Set<String> gridSGuideSet =  new LinkedHashSet<String>();


        gridSGuideSet.add(unitPosString);

        int c=0;

        do {
            if(c == 0) {
                guideConstruct(gridSGuideSet,unitPosString);
            }else{
                extractDataFromSet(gridSGuideSet);
//                guideConstruct(gridSGuideSet,"");

            }
            c++;
        }while (c < unitMaxMvt);

        System.out.println("La taille du set "+gridSGuideSet.size());

        // L'iterator nous permets de voir le contenu du set
//        Iterator iterator = gridSGuideSet.iterator();
//        while(iterator.hasNext()){
//            String element = (String) iterator.next();
//            System.out.println("Contenu du set : "+element);
//        }

        // Renvoie la taille du array
//        System.out.println(guideMvt.size());
        for (int i=0;i<guideMvt.size();i++) {
            System.out.println("Valeurs push : "+guideMvt.get(i)[0]+" / "+guideMvt.get(i)[1]);
        }

    // On envoie les coordonnées des tiles que doit peindre notre guide
        theGuide.setGrid(guideMvt);
    }

    // Ceci va nous redonner tout le contenu du Set
    public ArrayList<String> extractDataFromSet(Set<String> set){
        // L'iterator nous permets de voir et parcourir le contenu du set
        Iterator iterator = set.iterator();

        ArrayList<String> data = new ArrayList<String>();


        while(iterator.hasNext()){
            String element = (String) iterator.next();
            System.out.println("Contenu du set : "+element);
            data.add(element);
        }
        System.out.println("Nb data : "+data.size());

        return data;
    }




    public void guideConstruct(Set<String> guide, String gridSPos){
//        System.out.println(guide.size());
//        System.out.println(gridSPos);

        // Ça c'est pour sauvegarder la position dans gridS
        int yIndex = Integer.parseInt(gridSPos.substring(1));
        int xIndex=0;

        // On recherche le code de la tile dans gridS pour obtenir l'index en y
        for (int i = 0; i < 14;i++){
//            System.out.println("gridS : "+gridS[xIndex][i]);
            if (gridS[yIndex][i] == gridSPos){
//                System.out.println(gridSPos + " trouvé en y : "+ i +" et x : "+ xIndex);
                xIndex = i;
            }
        }

        System.out.println("y : "+yIndex);
        System.out.println("x : "+xIndex);


        // On parcourt les collisions pour savoir si i dans une direction c'est bloqué ou non
        for (int i=1;i<collisionGrid[yIndex][xIndex].length;i++){
            // Haut
            if (i == 1 && collisionGrid[yIndex][xIndex][i] == 1) {
                guide.add(gridS[yIndex-1][xIndex]);
            }
            // Droite
            if (i == 2 && collisionGrid[yIndex][xIndex][i] == 1) {
                guide.add(gridS[yIndex][xIndex + 1]);
            }
            // Bas
            if (i == 3 && collisionGrid[yIndex][xIndex][i] == 1) {
                guide.add(gridS[yIndex+1][xIndex]);
            }
            // Gauche
            if (i == 4 && collisionGrid[yIndex][xIndex][i] == 1) {
                guide.add(gridS[yIndex][xIndex-1]);
            }
        }
    }


    // Cette méthode va faire la même chose que précédemment a savoir tester les collisions et push dans l'array guideMvt si l'unité peut passer
    public void guidePath(int[] nextTile){
        int tilePosY = nextTile[0];
        int tilePosX = nextTile[1];

//        guideMvt.clear();

        // On parcourt les collisions pour savoir si i dans une direction c'est bloqué ou non
        for (int i=1;i<collisionGrid[tilePosY][tilePosX].length;i++){
            // Haut
            if (i == 1 && collisionGrid[tilePosY][tilePosX][i] == 1) {
                tmp = new int[]{tilePosY - 1, tilePosX};
                guideMvt.add(tmp);
            }
            // Droite
             if (i == 2 && collisionGrid[tilePosY][tilePosX][i] == 1) {
                 tmp = new int[]{tilePosY, tilePosX + 1};
                 guideMvt.add(tmp);
             }
             // Bas
             if (i == 3 && collisionGrid[tilePosY][tilePosX][i] == 1) {
                 tmp = new int[]{tilePosY + 1, tilePosX};
                 guideMvt.add(tmp);
             }
             // Gauche
             if (i == 4 && collisionGrid[tilePosY][tilePosX][i] == 1) {
                 tmp = new int[]{tilePosY, tilePosX - 1};
                 guideMvt.add(tmp);
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
