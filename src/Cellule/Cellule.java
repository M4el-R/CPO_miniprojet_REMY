package Cellule;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Maël
 */
public class Cellule {

    private boolean presenceBombe;
    private boolean presenceDrapeau;
    private boolean devoilee;
    private int nbBombesAdjacentes;

    public Cellule(boolean presenceBombe,boolean presenceDrapeau, boolean devoilee, int nbBombesAdjacentes) {
        this.presenceBombe = presenceBombe;
        this.devoilee = devoilee;
        this.nbBombesAdjacentes = nbBombesAdjacentes;
    }

    public boolean getPresenceBombe() {
        return this.presenceBombe;
    }
    
    public boolean getPresenceDrapeau(){
        return this.presenceDrapeau;
    }

    public boolean getdevoilee() {
        return this.devoilee;
    }

    public int getNbBombesAdjacentes() {
        return this.nbBombesAdjacentes;
    }

    public void placerBombe() {
        presenceBombe = true;
    }

    public void retirerBombe(){
        presenceBombe = false;
    }
    
    public void placerDrapeau(){
        presenceDrapeau = true;
    }
    
    public void retirerDrapeau(){
        presenceDrapeau = false;
    }
    public void revelerCellule() {
        devoilee = true;
    }
    
    
    public void setNbBombesAdjacentes(int nbBombesAdjacentes) {
        this.nbBombesAdjacentes = nbBombesAdjacentes;
    }

    public String toString(boolean devoilee, int nbBombesAdjacentes, boolean presenceBombe) {
        if (devoilee == false && presenceDrapeau == false) {
            return "?";
        }
        
        if(devoilee == false && presenceDrapeau ==true){
            return"D";
        }

        if (presenceBombe == true) {
            return "B";
        } else {
        }

        if (nbBombesAdjacentes == 0) {
            return " ";
        } else {
            String nbBombes = String.valueOf(nbBombesAdjacentes);
            return nbBombes;
        }

    }
}
