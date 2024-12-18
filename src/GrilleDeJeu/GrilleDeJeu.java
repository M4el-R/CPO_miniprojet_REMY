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
    
    /**
     *renvoie le nombre de lignes
     */
    public int getNbLines() {
        return this.nbLignes;
    }

    /**
     *renvoie le nombre de colonnes
     */
    public int getNbColonnes() {
        return this.nbColonnes;
    }

    /**
     *renvoie le nombre de bombes
     */
    public int getNbBombes() {
        return this.nbBombes;
    }

    /**
     *renvoie la matrice de jeu
     */
    public Cellule[][] getMatrice() {
        return this.matriceCellules;
    }
    
    /**
     * @param ligne 
     * @param colonne
     *devoile les premières cases en fonction de la ligne et colonne choisi
     */
    public void premier_coup(int ligne, int colonne) {

        aucuneBombeAutour(ligne, colonne);
        while (compteurBombe() != this.nbBombes) {
            int i = (int) (Math.random() * (nbLignes));
            int j = (int) (Math.random() * (nbColonnes));
            if (matriceCellules[i][j].getPresenceBombe() == false) {
                matriceCellules[i][j].placerBombe();

                aucuneBombeAutour(ligne, colonne);
                calculerBombesAdjacentes();
            }
        }

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                //System.out.println("coordonees " + (ligne + i) + " " + (colonne + j));
                revelerCellule(ligne + i, colonne + j);

            }
        }

        return;
    }
    
    /**
     * @param ligne 
     * @param colonne
     *enleve les bombes adjacentes à ligne colonne et sur les coordonnées(ligne, colonne) s'il y en a
     */
    public void aucuneBombeAutour(int ligne, int colonne) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((ligne + i <= 0) || (ligne + i >= nbLignes + 1) || (colonne + j <= 0) || (colonne + j >= nbColonnes + 1)) {

                } else {
                    if (matriceCellules[ligne + i - 1][colonne + j - 1].getPresenceBombe() == true) {
                        matriceCellules[ligne + i - 1][colonne + j - 1].retirerBombe();
                    }
                }
            }
        }
    }
    /**
     * @param ligne 
     * @param colonne
     *calcule le nombre de drapeau adjacents puis renvoi le nombre de drapeauu trouvé
     */
    
    public int drapeauAdjacents(int ligne, int colonne) {
        int cpt = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((ligne + i <= 0) || (ligne + i >= nbLignes + 1) || (colonne + j <= 0) || (colonne + j >= nbColonnes + 1)) {

                } else {

                    if (matriceCellules[ligne + i - 1][colonne + j - 1].getPresenceDrapeau() == true) {
                        cpt++;

                    }
                }
            }
        }
        return cpt;
    }
    
    /**
     * @param ligne 
     * @param colonne
     *devoile les cases autour de la case de coordonées (ligne, colonne) si son nombre de drapeau adjacents est egal a celui des bombes alentour
     */
    public void revelerAutour(int ligne, int colonne) {
        System.out.println(drapeauAdjacents(ligne, colonne));

        if (drapeauAdjacents(ligne, colonne) == matriceCellules[ligne - 1][colonne - 1].getNbBombesAdjacentes() && matriceCellules[ligne - 1][colonne - 1].getdevoilee() == true) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    revelerCellule(ligne + i, colonne + j);

                }
            }
        }
        return;
    }
    
    /**
     *renvoie le nombre de cases revele
     */
    public int nbCasesReveles() {
        int case_revele = 0;
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (reveler(i, j) == true) {
                    case_revele++;
                }
            }
        }
        return case_revele;

    }
    /**
     *renvoie true si toutes les cases sans bombes ont été revelé, false sinon
     */
    public boolean verifierVictoire() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (matriceCellules[i][j].getdevoilee() == false && matriceCellules[i][j].getPresenceBombe() == false) {
                    return false;
                }
            }

        }
        return true;

    }
    /**
     *renvoie true si une case avec une bombe a été revelé, false sinon
     */

    public boolean verifierDefaite() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (matriceCellules[i][j].getdevoilee() == true && matriceCellules[i][j].getPresenceBombe() == true) {
                    return true;
                }
            }

        }
        return false;

    }

     /**
     *@param ligne
     *@param colonne
     *renvoie si la case de coordonés(ligne, colonne)a été revelé
     */
    public boolean reveler(int ligne, int colonne) {
        if (matriceCellules[ligne][colonne].getdevoilee() == false) {
            return false;
        }
        return true;
    }
    
     /**
     *renvoie le nombre de bombes
     */
    public int compteurBombe() {
        int cpt = 0;
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (matriceCellules[i][j].getPresenceBombe() == true) {
                    cpt++;
                }
            }

        }
        return cpt;
    }

        /**
     *place des bombes sur la grille
     */
    public Cellule[][] placerBombesAleatoirement() {
        while (compteurBombe() != this.nbBombes) {
            int i = (int) (Math.random() * (nbLignes));
            int j = (int) (Math.random() * (nbColonnes));
            if (matriceCellules[i][j].getPresenceBombe() == false) {
                matriceCellules[i][j].placerBombe();
            }
        }
        return matriceCellules;
    }

        /**
     *calcule le nombre de bombes adjacentes sur la grille
     */
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

        /**
         *@param ligne
         * @param colonne
     *ajoute ou enleve un drapeau sur les coordonnées (ligne, colonne)
     */
    public void drapeau(int ligne, int colonne) {
        if (matriceCellules[ligne - 1][colonne - 1].getPresenceDrapeau() == false) {
            matriceCellules[ligne - 1][colonne - 1].placerDrapeau();
        } else {
            matriceCellules[ligne - 1][colonne - 1].retirerDrapeau();
        }
    }

    /**
         *@param ligne
         * @param colonne
     *revele la cellule de coordonées (ligne, colonne) et celles sans bombes adjacentes alentour
     */
    public void revelerCellule(int ligne, int colonne) {
        // 1️⃣ Vérification des bornes de la grille (éviter l'IndexOutOfBoundsException)
        if (ligne - 1 < 0 || ligne - 1 >= nbLignes || colonne - 1 < 0 || colonne - 1 >= nbColonnes || matriceCellules[ligne - 1][colonne - 1].getdevoilee() == true || matriceCellules[ligne - 1][colonne - 1].getPresenceDrapeau() == true) {
            return;
        }
        matriceCellules[ligne - 1][colonne - 1].revelerCellule();

        if (matriceCellules[ligne - 1][colonne - 1].getPresenceBombe() || matriceCellules[ligne - 1][colonne - 1].getNbBombesAdjacentes() > 0) {
            return;
        }

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                revelerCellule(ligne + i, colonne + j);
            }
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
