package com.labyrinth.yugioh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel implements MouseListener {
    // Celui ci servira a afficher toutes les infos utiles pour le joueur (description créatures, créatures restantes,etc.)
    //InfoPanel infoPanelContainer = new InfoPanel();
    // tSize correspond à la taille de nos tiles
    int tSize = 60;
    // Même valeur pour notre taille et width qui seront identiques on stocke dans cette variable par simplicité
    int unitSize = 30;
    int gpW = 920;
    int gpH = 720;
    int grid[][] = {
            {1,8,8,10,4,1,4,1,4,1,8,8,8,4},
            {2,7,5,10,0,7,5,7,9,5,3,5,0,3},
            {11,5,6,4,5,3,5,7,2,3,1,3,9,11},
            {11,2,4,5,0,10,3,2,4,1,7,1,3,11},
            {11,8,3,2,0,8,4,1,7,9,5,3,1,11},
            {11,5,10,4,9,5,0,0,7,9,2,10,7,11},
            {11,3,1,7,9,5,3,2,6,0,4,1,6,11},
            {11,1,3,5,3,2,4,1,10,0,7,2,4,11},
            {11,9,1,3,1,4,5,7,1,7,2,8,7,11},
            {1,0,7,1,7,9,5,7,5,0,10,7,5,4},
            {2,6,6,6,3,2,3,2,3,2,10,6,6,3}
    };

    InfoPanel iPan;
    GameMaster gameMaster;
    OrderPanel orderP = new OrderPanel(100,100);
    // Ceci correspond à l'unité qui va agir
    Unit choosedUnit;

    Unit blueUnit;
    Unit unit1 = new Unit(this,orderP,unitSize/2,60+unitSize/2,"Blackland Fire Dragon",4,2200,2000);
    Unit unit2 = new Unit(this,orderP,790,60+unitSize/2,"Curse of Dragon",5,2200,1900);

    // Constructeur dans lequel le addMousListener a été mis pour éviter notamment des problèmes avec repaint
    public GamePanel(){
        this.addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0,0,gpW,gpH);

        // Une fois nos 2 conteneurs créés on génère le labyrinthe
        generateLabyrinth(g);
    }


    // Cette méthode va générer le labyrinthe
    public void generateLabyrinth(Graphics g){

        // Les futures tiles feront 60 sur 60 en taille
        // Le plateau fait 14 de long sur 11 de haut
        // Cette boucle va s'occuper de la hauteur
        for (int i=0;i<grid.length;i++) {
            // Et celle ci de la longueur
            // grid[i] permets de changer de ligne dans un tableau 2D (en gros ça fait grid[de 0 à 10 lignes][et de 0 à 13 colonnes])
            for (int j=0;j<grid[i].length;j++) {
                // Un switch sera mieux que plusieurs if (et ça permets d'utiliser quelque chose de peu utilisé)
                switch (grid[i][j]){
                    case 0:
                        drawTile(g,j,i,0);
                        break;
                    case 1:
                        drawTile(g,j,i,1);
                        break;
                    case 2:
                        drawTile(g,j,i,2);
                        break;
                    case 3:
                        drawTile(g,j,i,3);
                        break;
                    case 4:
                        drawTile(g,j,i,4);
                        break;
                    case 5:
                        drawTile(g,j,i,5);
                        break;
                    case 6:
                        drawTile(g,j,i,6);
                        break;
                    case 7:
                        drawTile(g,j,i,7);
                        break;
                    case 8:
                        drawTile(g,j,i,8);
                        break;
                    case 9:
                        drawTile(g,j,i,9);
                        break;
                    case 10:
                        drawTile(g,j,i,10);
                        break;
                    case 11:
                        drawTile(g,j,i,11);
                        break;
                }
            }
        }

        gameMaster.getGrid(grid);
        generateUnits(g);
    }

    // Ajoute les unités sur le labyrinthe
    // Pour l'instant et pour les tests ce sera 7 pions sur chaque spawn
    public void generateUnits(Graphics g){

        // Puisque les points de spawn sur ce labyrinth sont fixés il suffit d'une seule boucle pour la colonne 0 et 13
        for (int i=0;i<grid.length;i++){
            // Les tiles 11 correspondent à nos points de spawn
            if (grid[i][0]==11){
                Unit blueUnit = new Unit(this, orderP,unitSize/2,i*tSize+unitSize/2, "blue",7,3000,2500);
                g.setColor(Color.blue);
                g.fillOval(blueUnit.getX(),blueUnit.getY(),blueUnit.getW(),blueUnit.getH());
            }

            if (grid[i][13]==11){
                Unit redUnit = new Unit(this, orderP,gpW-tSize*2,i*tSize+unitSize/2,"red",7,3000,2500);
                g.setColor(Color.red);
                g.fillOval(redUnit.getX(),redUnit.getY(),redUnit.getW(),redUnit.getH());
            }
        }


        g.setColor(Color.magenta);
        g.fillOval(unit1.getX(),unit1.getY(),unit1.getW(),unit1.getH());
        // Pour enclencher les événements liés à la souris
        this.addMouseListener(unit1);

        g.setColor(Color.green);
        g.fillOval(unit2.getX(),unit2.getY(),unit2.getW(),unit2.getH());
        this.addMouseListener(unit2);


        Unit[] unitArray = {unit1,unit2};
        gameMaster.getUnit(unitArray);
    }

    // Permets de dessiner la tile demandée
    public void drawTile(Graphics g,int j,int i,int tilenb){
        try {
            // On créé notre variable de type Image puis on la dessine selon le tilenb
            Image tile = ImageIO.read(new File("assets/game/labyrinth/tiles/tile"+tilenb+".png"));
            g.drawImage(tile,j * tSize, i * tSize, this);
        } catch (IOException e) {
            System.out.println("Erreur pour l'affichage de la tile");
        }
    }

    GuideUnitPanel theGuide = new GuideUnitPanel(this, gpW, gpH);
    // Permets de dessiner le guide de mouvement et d'attaque
    public void drawGuide(Unit unitToGuide){
//        GuideUnitPanel theGuide = gameMaster.drawAttackRange(unitToGuide);
        gameMaster.newGuidDraw(theGuide, unitToGuide);
        add(theGuide);
    }



    // Récupère ce que la class Unit envoie lorsqu'on a cliqué dessus
    public void collectUnitData(Unit unit){
        choosedUnit = unit;
//        System.out.println(name);
        iPan.displayUnitInfo(choosedUnit);
    }

    // On transmets les coordonnées de la souris
    // Retourne les coordonnées de la tile sa position x, y et son id entrée dans la grid
    public int[] getTileInfo(int x,int y){
        // En divisant par la tSize on obtient de quoi parcourir la variable grid[gridY][gridX] et puisque la variable est un entier java s'occuper d'enlever les nombreux chiffres après la virgule
        int gridX = x/tSize;
        int gridY = y/tSize;
//        System.out.println(gridX);
//        System.out.println(gridY);
//        System.out.println(grid[gridY][gridX]);
        int tileID = grid[gridY][gridX];

        int[] data = {gridX,gridY,tileID};
        return data;
    }


    public void getInfoPanel(InfoPanel infoPanel){
        iPan = infoPanel;
    }

    public void getGameMaster(GameMaster gm){
        gameMaster = gm;
//        System.out.println(gameMaster);
    }

    public void moveAndPaintUnit(int newX,int newY){
        choosedUnit.move(newX,newY);

        // On envoie à orderP l'unité auquel elle est liée
        orderP.setUnit(choosedUnit);
        add(orderP);
        orderP.reveal();
        // On mets le Layout à null pour pouvoir avec setBounds le placer n'importe où (Si la fenêtre est redimensionnée il y aura des soucis, ça fonctionne comme le position absolute en css
        setLayout(null);
        orderP.setBounds(newX + 30, newY + 30,orderP.getW(),orderP.getH());
        repaint();
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // Si une unité à été "sélectionnée" (clic gauche dessus) alors on bouge cette unité
        if (choosedUnit != null) {
//        System.out.println(e.getSource().getClass());
            // Si le bouton cliqué est celui de droite
            if (e.getButton() == 3) {
                // Si l'unité peut agir alors elle est autorisée a se déplacer
                if (choosedUnit.canAct == true){
                    // Nous récupérons les infos de la tile dans l'ordre X,Y et ID.
                    // e.getX() renvoie la position où à eu lieu l'événement (ici un clic)
                    int tilePos[] = getTileInfo(e.getX(),e.getY());

                    // On bouge l'unité à la tile ciblé tout en centrant l'unité en ajoutant unitSize/2
                    moveAndPaintUnit(tilePos[0]*tSize+unitSize/2, tilePos[1]*tSize+unitSize/2);
                }else{
                    // Le code suivant permets de faire une fenêtre popup
                    JOptionPane msgCantMove;
                    msgCantMove = new JOptionPane();
                    msgCantMove.showMessageDialog(null, "Cette unité a déjà bougé durant ce tour", "Erreur", JOptionPane.ERROR_MESSAGE);
                }


            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
