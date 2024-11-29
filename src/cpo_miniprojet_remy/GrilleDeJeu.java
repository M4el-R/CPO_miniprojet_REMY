/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpo_miniprojet_remy;

/**
 *
 * @author Maël
 */
public class GrilleDeJeu {

    private Cellule[][] matriceCellules;
    private int nbLignes;
    private int nbColonnes;
    private int nbBombes;

    public int getNbLines() {
        return this.nbLignes;
    }

    public int getNbColonnes() {
        return this.nbColonnes;
    }

    public int getNbBombes() {
        return this.nbBombes;
    }

    public Cellule[][] placerBombesAleatoirement(int nbBombes) {
        int bombeplace = 0;
        while (bombeplace != nbBombes) {
            int i = (int) (Math.random() * (nbLignes));
            int j = (int) (Math.random() * (nbColonnes));
            if (matriceCellules[i][j].getPresenceBombe() == false) {
                matriceCellules[i][j].placerBombe();
                bombeplace += 1;
            }
        }
        return matriceCellules;
    }

    public Cellule[][] calculerBombesAdjacentes() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; i < nbColonnes; i++) {
                int bombe = 0;
                // verification en haut
                if (i - 1 >= 0 && j -1 >=0 && matriceCellules[i - 1][j-1].getPresenceBombe() == true) bombe++;
                if (i - 1 >= 0 && j >=0 && matriceCellules[i - 1][j].getPresenceBombe() == true) bombe++;
                if (i - 1 >= 0 && j +1< nbColonnes && matriceCellules[i - 1][j+1].getPresenceBombe() == true) bombe++;
                if (i + 1 <nbLignes && j -1 >=0 && matriceCellules[i + 1][j-1].getPresenceBombe() == true) bombe++;
                if (i + 1 <nbLignes && j >=0 && matriceCellules[i - 1][j].getPresenceBombe() == true) bombe++;
                if (i + 1 <nbLignes && j +1< nbColonnes && matriceCellules[i + 1][j+1].getPresenceBombe() == true) bombe++;
                if (j - 1 >= 0 && matriceCellules[i][j-1].getPresenceBombe() == true) bombe++;
                if (j + 1 <nbLignes && matriceCellules[i][j+1].getPresenceBombe() == true) bombe++;
        
                matriceCellules[i][j].setNbBombesAdjacentes(bombe);
            }
        }
        return matriceCellules;
    }

}
