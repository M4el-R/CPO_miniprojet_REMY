/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cpo_miniprojet_remy;

import GrilleDeJeu.*;
import Cellule.*;
import java.util.ArrayList;
import java.util.Scanner;
import interface_graphique.*;

/**
 *
 * @author Maël
 */
public class CPO_miniprojet_REMY {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc;
        sc = new Scanner(System.in);
        System.out.println("Choisissez une grille x*x");
        int n = sc.nextInt();
        int bombe = n;
        Cellule[][] tab = new Cellule[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tab[i][j] = new Cellule(false, false, 0);
            }
        }

        GrilleDeJeu grille = new GrilleDeJeu(tab, n, n, bombe);
        Partie tableau = new Partie(grille);
        tableau.initialiserPartie();
        System.out.println(tableau);

        int lignec = 10;
        int colonnec = 10;
        while (tableau.verifierVictoire()==false ^ tableau.verifierDefaite() == true) {
            sc = new Scanner(System.in);
            System.out.println("Choisissez une ligne");
            lignec = sc.nextInt();
            System.out.println("Choisissez une colonne");
            colonnec = sc.nextInt();
            tableau.tourDeJeu(lignec, colonnec);
            System.out.println(tableau);
            if(tableau.verifierDefaite()==true){
                System.out.println("Vous avez perdu");
            }
            if(tableau.verifierVictoire()==true){
                System.out.println("Vous avez gagne");
            }
            
        }
    }

}
