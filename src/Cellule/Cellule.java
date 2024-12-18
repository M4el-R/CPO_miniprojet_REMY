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
    private int nbDrapeauAdjacents;

    public Cellule(boolean presenceBombe,boolean presenceDrapeau, boolean devoilee, int nbBombesAdjacentes, int nbDrapeauAdjacents) {
        this.presenceBombe = presenceBombe;
        this.devoilee = devoilee;
        this.nbBombesAdjacentes = nbBombesAdjacentes;
    }

    /**
     *renvoie l'état presenceBombe
     */
    public boolean getPresenceBombe() {
        return this.presenceBombe;
    }
    
    /**
     *renvoie l'état presenceDrapeau
     */
    public boolean getPresenceDrapeau(){
        return this.presenceDrapeau;
    }
    
    /**
     *renvoie l'état dévoilé
     */
    public boolean getdevoilee() {
        return this.devoilee;
    }

    /**
     *renvoie le nombre de bombes adjacentes
     */
    public int getNbBombesAdjacentes() {
        return this.nbBombesAdjacentes;
    }
    
    /**
     * renvoie le nombre de drapeau adjacents
     */
    public int getNbDrapeauAdjacents(){
        return this.nbDrapeauAdjacents;
    }
    
    /**
     *place une bombe
     */
    public void placerBombe() {
        presenceBombe = true;
    }
    
    /**
     *retire une bombe
     */
    public void retirerBombe(){
        presenceBombe = false;
    }
    
    /**
     *place un drapeau
     */
    public void placerDrapeau(){
        presenceDrapeau = true;
    }
    
    /**
     *retire un drapeau
     */
    public void retirerDrapeau(){
        presenceDrapeau = false;
    }
    
    /**
     *passe l'état devoilee à true
     */
    public void revelerCellule() {
        devoilee = true;
    }
    
    /**
     *
     * @param nbBombesAdjacentes
     * initialise le nombre de bombes adjacentes
     */
    public void setNbBombesAdjacentes(int nbBombesAdjacentes) {
        this.nbBombesAdjacentes = nbBombesAdjacentes;
    }

    public String toString(boolean devoilee, int nbBombesAdjacentes, boolean presenceBombe) {
        if (devoilee == false && presenceDrapeau == false) {
            return "?";
        }
        
        if(devoilee == false && presenceDrapeau ==true){
            return"🚩";
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
