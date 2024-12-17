/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CelluleGraphique;

import Cellule.Cellule;
import java.awt.Graphics;
import javax.swing.JButton;

/**
 *
 * @author Maël
 */
public class CelluleGraphique extends JButton {

    public int x;
    public int y;
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";

    Cellule celluleAssociee;

    public CelluleGraphique(int largeur, int hauteur, Cellule celluleAssociee) {
        this.x = largeur;
        this.y = hauteur;
        this.celluleAssociee = celluleAssociee;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        if (celluleAssociee.getPresenceBombe() == true && celluleAssociee.getdevoilee() == true) {
            this.setText("B");

        } else if (celluleAssociee.getdevoilee() == true && celluleAssociee.getNbBombesAdjacentes() == 0) {
            this.setText("0");
        } else if (celluleAssociee.getdevoilee() == true && celluleAssociee.getNbBombesAdjacentes() != 0) {
            this.setText(String.valueOf(celluleAssociee.getNbBombesAdjacentes()));

        } else if (celluleAssociee.getPresenceDrapeau() == true && celluleAssociee.getdevoilee() == false) {
            this.setText("🚩");
        } else if (celluleAssociee.getdevoilee() == false) {
            this.setText(" ");

        }
    }
}
