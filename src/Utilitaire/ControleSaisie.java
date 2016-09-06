/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitaire;

/**
 *
 * @author ldescamps
 */
public class ControleSaisie {
    
    private int longueur;
    boolean validationLongueur;
    boolean validationNonVide;
    
    //Méthode controle longueur d'un champ
    public void ctrlLongueur() {
        try {
            if ((longueur > 2) && (longueur < 30)) {
                validationLongueur = true;
                System.out.println("validationLongueur vrai");
            } else {
                validationLongueur = false;
                System.out.println("validationLongueur fausse");
            }
        } catch (Exception e) {

        }
    }
    
    //Méthode controle champ vide
    public void ctrlNonVide() {
        try {
            if (longueur > 0) {
                validationNonVide = true;
                System.out.println("validationNonVide vrai");
            } else {
                validationNonVide = false;
                System.out.println("validationNonVide fausse");
            }
        } catch (Exception e) {

        }
    }
    
    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public boolean isValidationLongueur() {
        return validationLongueur;
    }

    public boolean isValidationNonVide() {
        return validationNonVide;
    }
    
}
