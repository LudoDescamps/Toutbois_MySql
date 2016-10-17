/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

/**
 *
 * @author Tsoutsou
 */
public class Representant extends Societe{
    private static int cptRep = 0;
    private String nomRepresentant;
    private int idRepresentant;
    private String salaireFixe;
    private String tauxCommission;

    public Representant(String nomRepresentant, int idRepresentant, String salaireFixe, String tauxCommission, String nom, String prenom, 
            String numRueAdresse, String cp, String ville, String pays, String telephone, String telephonePortable, String fax, String email,
            String cedex, String complementAdresse) {
        super(nom, prenom, numRueAdresse, cp, ville, pays, telephone, telephonePortable, fax, email, cedex, complementAdresse);
        this.nomRepresentant = nomRepresentant;
        this.salaireFixe = salaireFixe;
        this.tauxCommission = tauxCommission;
        Representant.cptRep ++;
        this.idRepresentant = Representant.cptRep;
    }

    public Representant(){
        
    }

    public String getNomRepresentant() {
        return nomRepresentant;
    }

    public void setNomRepresentant(String nomRepresentant) {
        this.nomRepresentant = nomRepresentant;
    }

    public int getIdRepresentant() {
        return idRepresentant;
    }

    public void setIdRepresentant(int idRepresentant) {
        this.idRepresentant = idRepresentant;
    }

    public String getSalaireFixe() {
        return salaireFixe;
    }

    public void setSalaireFixe(String salaireFixe) {
        this.salaireFixe = salaireFixe;
    }

    public String getTauxCommission() {
        return tauxCommission;
    }

    public void setTauxCommission(String tauxCommission) {
        this.tauxCommission = tauxCommission;
    }

    public static int getCptRep() {
        return cptRep;
    }

    public static void setCptRep(int cptRep) {
        Representant.cptRep = cptRep;
    }

    @Override
    public String toString() {
        return "Representant{" + "nomRepresentant=" + nomRepresentant + ", idRepresentant=" + idRepresentant + ", salaireFixe=" + salaireFixe + ", tauxCommission=" + tauxCommission + 
                ", nom=" + getNom() + ", prenom=" + getPrenom() + ", adresse=" +getNumRueAdresse() + ", cp=" + getCp() + ", ville=" + getVille() + ", pays=" + getPays() + ", telephone=" + getTelephone() + ", telephonePortable=" +
                getTelephonePortable() + ", fax=" + getFax() + ", email=" + getEmail() + '}';
    }

    

    
    
}