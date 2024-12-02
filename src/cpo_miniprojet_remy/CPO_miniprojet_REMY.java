/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cpo_miniprojet_remy;

import GrilleDeJeu.*;
import Cellule.*;
import java.util.ArrayList;
import java.util.Scanner;

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
        int ligne = 4;
        int colonne = 4;
        int bombe = 4;
        Cellule[][] tab = new Cellule[ligne][colonne];
        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < colonne; j++) {
                tab[i][j] = new Cellule(false, false, 0);
            }
        }

        GrilleDeJeu tableau = new GrilleDeJeu(tab, ligne, colonne, bombe);
        tableau.placerBombesAleatoirement();
        System.out.println(tableau);

        Scanner sc;
        int lignec = 10;
        int colonnec = 10;
        while (ligne == 4) {
            sc = new Scanner(System.in);
            System.out.println("Choisissez une ligne");
            lignec = sc.nextInt();
            System.out.println("Choisissez une colonne");
            colonnec = sc.nextInt();
            tableau.calculerBombesAdjacentes();
            tableau.revelerCellule(lignec, colonnec);
            System.out.println(tableau);
        }
    }

}
