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
    private String nomRepresentant;
    private String idRepresentant;
    private String salaireFixe;
    private String tauxCommission;

    public Representant(String nomRepresentant, String idRepresentant, String salaireFixe, String tauxCommission, String nom, String prenom, String numRueAdresse, String cp, String ville, String pays, String telephone, String telephonePortable, String fax, String email) {
        super(nom, prenom, numRueAdresse, cp, ville, pays, telephone, telephonePortable, fax, email);
        this.nomRepresentant = nomRepresentant;
        this.idRepresentant = idRepresentant;
        this.salaireFixe = salaireFixe;
        this.tauxCommission = tauxCommission;
    }

    public String getNomRepresentant() {
        return nomRepresentant;
    }

    public void setNomRepresentant(String nomRepresentant) {
        this.nomRepresentant = nomRepresentant;
    }

    public String getIdRepresentant() {
        return idRepresentant;
    }

    public void setIdRepresentant(String idRepresentant) {
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
    
}
