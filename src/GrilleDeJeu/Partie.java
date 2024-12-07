/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GrilleDeJeu;

import Cellule.*;
import GrilleDeJeu.*;
import java.util.Scanner;

/**
 *
 * @author Maël
 */
public class Partie  {
    
    public GrilleDeJeu grille;

    public Partie(GrilleDeJeu grille) {
        this.grille = grille;
    }
    
    

    public GrilleDeJeu initialiserPartie() {
        Scanner sc;
        sc = new Scanner(System.in);
        System.out.println("Choisissez une grille x*x");
        int n = sc.nextInt();
        int bombe = Math.round(n*n/10);
        Cellule[][] tab = new Cellule[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tab[i][j] = new Cellule(false, false, 0);
            }
        }
        GrilleDeJeu Grille = new GrilleDeJeu(tab, n, n, bombe);

        grille.placerBombesAleatoirement();
        grille.calculerBombesAdjacentes();
        return grille;
    }

    public GrilleDeJeu tourDeJeu(int ligne, int colonne) {
        grille.revelerCellule(ligne, colonne);
        return grille;
    }
    
    public boolean verifierVictoire(){
        for (int i = 0; i < grille.getNbLines(); i++) {
            for (int j = 0; j < grille.getNbColonnes(); j++) {
                if(grille.getMatrice()[i][j].getdevoilee() == false && grille.getMatrice()[i][j].getPresenceBombe() == false) {
                    return false;
                }
            }

        }
        return true;

    }
    public boolean verifierDefaite(){
        for (int i = 0; i < grille.getNbLines(); i++) {
            for (int j = 0; j < grille.getNbColonnes(); j++) {
                if(grille.getMatrice()[i][j].getdevoilee() == true && grille.getMatrice()[i][j].getPresenceBombe() == true) {
                    return true;
                }
            }

        }
        return false;
    }
    
    public void demarrerPartie(Partie grille){
        while (verifierVictoire()==false) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Choisissez une ligne");
            int ligne = sc.nextInt();
            System.out.println("Choisissez une colonne");
            int colonne = sc.nextInt();
            tourDeJeu(ligne, colonne);
            System.out.println(grille);
            
        }



    }
        @Override
    public String toString() {
        String texte = " ";
        for (int i = 0; i < grille.getNbColonnes(); i++) {
            texte += " " + String.valueOf(i + 1);
        }
        for (int i = 0; i < grille.getNbLines(); i++) {
            texte += "\n" + String.valueOf(i + 1);
            for (int j = 0; j < grille.getNbColonnes(); j++) {
                texte += " " + grille.getMatrice()[i][j].toString(grille.getMatrice()[i][j].getdevoilee(), grille.getMatrice()[i][j].getNbBombesAdjacentes(), grille.getMatrice()[i][j].getPresenceBombe());
            }
        }
        return texte;
    }

}

