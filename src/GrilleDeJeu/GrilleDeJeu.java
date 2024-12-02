/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GrilleDeJeu;

import Cellule.Cellule;

/**
 *
 * @author Maël
 */
public class GrilleDeJeu {

    private Cellule[][] matriceCellules;
    private int nbLignes;
    private int nbColonnes;
    private int nbBombes;

    public GrilleDeJeu(Cellule[][] matriceCellules, int nbLignes, int nbColonnes, int nbBombes) {
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.nbBombes = nbBombes;
        this.matriceCellules = matriceCellules;

    }

    public int getNbLines() {
        return this.nbLignes;
    }

    public int getNbColonnes() {
        return this.nbColonnes;
    }

    public int getNbBombes() {
        return this.nbBombes;
    }

    public Cellule[][] placerBombesAleatoirement() {
        int bombeplace = 0;
        while (bombeplace != this.nbBombes) {
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
            for (int j = 0; j < nbColonnes; j++) {
                int bombe = 0;
                if (i - 1 >= 0 && j - 1 >= 0 && matriceCellules[i - 1][j - 1].getPresenceBombe() == true) {
                    bombe++;
                }
                if (i - 1 >= 0 && j >= 0 && matriceCellules[i - 1][j].getPresenceBombe() == true) {
                    bombe++;
                }
                if (i - 1 >= 0 && j + 1 < nbColonnes && matriceCellules[i - 1][j + 1].getPresenceBombe() == true) {
                    bombe++;
                }
                if (i + 1 < nbLignes && j - 1 >= 0 && matriceCellules[i + 1][j - 1].getPresenceBombe() == true) {
                    bombe++;
                }
                if (i + 1 < nbLignes && j >= 0 && matriceCellules[i + 1][j].getPresenceBombe() == true) {
                    bombe++;
                }
                if (i + 1 < nbLignes && j + 1 < nbColonnes && matriceCellules[i + 1][j + 1].getPresenceBombe() == true) {
                    bombe++;
                }
                if (j - 1 >= 0 && matriceCellules[i][j - 1].getPresenceBombe() == true) {
                    bombe++;
                }
                if (j + 1 < nbLignes && matriceCellules[i][j + 1].getPresenceBombe() == true) {
                    bombe++;
                }

                matriceCellules[i][j].setNbBombesAdjacentes(bombe);
            }
        }
        return matriceCellules;
    }

    public Cellule[][] revelerCellule(int ligne, int colonne) {
        if (matriceCellules[ligne-1][colonne-1].getPresenceBombe() == true || matriceCellules[ligne-1][colonne-1].getNbBombesAdjacentes() != 0) {
            matriceCellules[ligne-1][colonne-1].revelerCellule();
            return matriceCellules;
        } else {
            matriceCellules[ligne-1][colonne-1].revelerCellule();
            return matriceCellules;
        }
    }

 

    
    
    @Override
    public String toString() {
        String texte = " ";
        for (int i = 0; i < nbColonnes; i++) {
            texte += " " + String.valueOf(i + 1);
        }
        for (int i = 0; i < nbLignes; i++) {
            texte += "\n" + String.valueOf(i + 1);
            for (int j = 0; j < nbColonnes; j++) {
                texte += " " + matriceCellules[i][j].toString(matriceCellules[i][j].getdevoilee(), matriceCellules[i][j].getNbBombesAdjacentes(), matriceCellules[i][j].getPresenceBombe());
            }
        }
        return texte;
    }

}
